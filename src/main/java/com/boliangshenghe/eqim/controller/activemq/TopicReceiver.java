package com.boliangshenghe.eqim.controller.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.stereotype.Component;
/**
 * test
 * @author xuzj
 *
 */
@Component
public class TopicReceiver implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println("TopicReceiver1接收到消息eqim:"
					+ ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}