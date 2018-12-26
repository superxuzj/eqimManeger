package com.boliangshenghe.eqim.util;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.google.protobuf.ByteString;
import com.hikvision.cms.api.eps.beds.face.EventDis;


public class MqTest {

	/**
	 * 10.33.47.176:61618和openapi.vss.topic可通过openapi【事件订阅接口】获得
	 */
    public static final String BROKER_URL = "failover:(tcp://192.168.1.201:61616)?timeout=2000";
	//public static final String BROKER_URL = "failover:(tcp://221.219.243.82:61618)?timeout=2000";
	//public static final String BROKER_URL = "failover:(tcp://10.115.5.117:61618)?timeout=2000";
    
    /**
	 * 10.33.47.176:61618和openapi.vss.topic可通过openapi【事件订阅接口】获得
	 */
    public static final String TARGET = "openapi.fas.topic";
    
	public static void main(String[] args) {
        
        Connection connection = null;
        Session session = null;
        try {
            // 创建链接工厂
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(BROKER_URL);
            // 通过工厂创建一个连接
            connection = factory.createConnection();
            // factory.createConnection(userName, password)
            // 启动连接
            connection.start();
            // 第一个参数表示是否使用事务，第二个参数指定消息的确认模式
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic(TARGET);
            MessageConsumer consumer = session.createConsumer(topic);
            // 消费者异步接收topic里的消息
            consumer.setMessageListener(new MessageListener() {
                
                public void onMessage(Message msg) {
                    try {
                    	System.out.println(msg);
                    	if (msg instanceof BytesMessage) {
                            BytesMessage bytesMessage = (BytesMessage)msg;
                            long length = bytesMessage.getBodyLength();
                            byte[] bt = new byte[(int)length];
                            // 将BytesMessage转换为byte类型
                            bytesMessage.readBytes(bt);
                          // System.out.println(bytesMessage);
                           EventDis.CommEventLog parseFrom = EventDis.CommEventLog.parseFrom(bt);
                        // 输出壳文件字段
                           if(parseFrom.getEventType()==131668) {
                        	   System.out.println(parseFrom.toString()+"  ---------commEventLog-------------    ");
                        	   System.out.println(parseFrom.getExtInfo().toStringUtf8()+" ----------ExtInfo------");
                           }
                          
                           /*System.out.println(parseFrom.getEventType()+"22222222222");
                            System.out.println(parseFrom.getEventTypeName()+"33333333333333");*/
                            //System.out.println(parseFrom.getExtInfo().toString()+"44444444444");
                           /*System.out.println(parseFrom.getEventTypeName()+"  EventTypeName");
                           System.out.println(parseFrom.getSourceName() +"  SourceName");
                           System.out.println(parseFrom.getUnitIdx() +"  UnitIdx");*/
                            // 扩展字段，此字段为设备上报事件内容，部分事件需要使用pb文件再次解析
                            ByteString extInfo = parseFrom.getExtInfo();
                            String xmlStr = extInfo.toStringUtf8();
                            // 输出扩展字段
                            //System.out.println(xmlStr+"  xmlStr");
                            
                            /*if(extInfo!=null && extInfo.toStringUtf8().length()>5) {
                            	try {
                            		 //获取Document 对象
                                    Document documentRoot = DocumentHelper.parseText(extInfo.toStringUtf8());
                                    //获取根节点
                                    Element roote = documentRoot.getRootElement();
                                    //获取根节点下的节点：
                                    Element picUrlE = roote.element("PicUrl");
                                    Element humanFeature = roote.element("HumanFeature");
                                    
                                    System.out.println(picUrlE.getText()+"  PicUrl");
                                    //获取根节点下的节点：
                                    Element ageGroupE = humanFeature.element("AgeGroup");
                                    System.out.println(ageGroupE.getText()+"  AgeGroup");
                                    
                                    Element eyeGlassE = humanFeature.element("EyeGlass");
                                    System.out.println(eyeGlassE.getText()+"  EyeGlass");
								} catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}
                            	
                            }*/
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
