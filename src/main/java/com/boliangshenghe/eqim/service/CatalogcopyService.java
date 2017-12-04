package com.boliangshenghe.eqim.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.controller.activemq.TopicSender;
import com.boliangshenghe.eqim.entity.Catalog;
import com.boliangshenghe.eqim.entity.Catalogcopy;
import com.boliangshenghe.eqim.entity.Company;
import com.boliangshenghe.eqim.entity.Jdata;
import com.boliangshenghe.eqim.entity.MessageRecord;
import com.boliangshenghe.eqim.entity.User;
import com.boliangshenghe.eqim.repository.CatalogcopyMapper;
import com.boliangshenghe.eqim.repository.CompanyMapper;
import com.boliangshenghe.eqim.repository.JdataMapper;
import com.boliangshenghe.eqim.repository.MessageRecordMapper;
import com.boliangshenghe.eqim.repository.UserMapper;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.boliangshenghe.eqim.util.DateUtils;
import com.boliangshenghe.eqim.util.DesUtils;
import com.boliangshenghe.eqim.util.HttpClientUtil;
import com.boliangshenghe.eqim.util.JsonUtils;
import com.boliangshenghe.eqim.util.SmsUtils;
import com.github.pagehelper.PageHelper;

@Service
public class CatalogcopyService {
	
	@Autowired
	CatalogcopyMapper catalogcopyMapper;
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	JdataMapper jdataMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	@Autowired
	MessageRecordMapper messageRecordMapper;
	
	
	
	@Resource
	TopicSender topicSender;
	
	private String eventid_temp = CommonUtils.SEARCH_TIME;
	
	public int insertSelective(Catalogcopy catalogcopy) {
        return catalogcopyMapper.insertSelective(catalogcopy);
    }
	
    public Catalogcopy selectByPrimaryKey(String id){
    	return catalogcopyMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Catalogcopy record){
    	return catalogcopyMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Catalogcopy> selectCatalogcopyList(Catalogcopy record){
    	List<Catalogcopy> list = catalogcopyMapper.selectCatalogcopyList(record);
    	return list;
    }
    
    public Catalogcopy selectCatalogcopyByEventId(String eventId){
    	Catalogcopy record = new Catalogcopy();
    	record.setEventId(eventId);
    	List<Catalogcopy> list = catalogcopyMapper.selectCatalogcopyList(record);
    	if(null!=list && list.size()>0){
    		return list.get(0);
    	}
    	return null;
    }
    
    
    //根据Eventid去重
    public Set<String> selectCatalogcopyEventIDList(Catalogcopy record){
    	List<Catalogcopy> jlist = catalogcopyMapper.selectCatalogcopyEventIDList(record);
    	Set<String> jset = new HashSet<String>();
    	for (Catalogcopy jdata : jlist) {
    		jset.add(jdata.getEventId());
		}
    	return jset;
    }
    
    public PageBean<Catalogcopy> getCatalogcopyByPage(Catalogcopy record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Catalogcopy> list = this.selectCatalogcopyList(record);
        return new PageBean<Catalogcopy>(list);
    }
    
    /**
     * 定时任务代码
     */
    public void insertrecordByTask(){
    	Catalog record = new Catalog();
    	System.out.println(eventid_temp+" eventid_temp");
    	record.setEventId(eventid_temp);//获取源数据
    	List<Catalog> listsource = catalogService.selectCatalogList(record);
    	System.out.println(listsource.size() +" size" );
    	//Set<String> eventids = this.selectCatalogcopyEventIDList(new Catalogcopy());
    	if(null!= listsource&& listsource.size()>0){
    		for (Catalog catalog : listsource) {
    			Catalogcopy cl = this.selectCatalogcopyByEventId(catalog.getEventId());
    			if(null!=cl && cl.getJsonstate().equals("1")){//复制表里面已经有了数据，也有了json数据,说明该记录处理完了
    				eventid_temp = catalog.getEventId();//重置查询条件，减少查询次数
    				continue;
    			}else if(null!=cl && cl.getJsonstate().equals("2")){//复制表里面已经有了数据，没有json数据
    				Jdata jdata = new Jdata();
    				jdata.setEventid(catalog.getEventId());
					List<Jdata> jlist = jdataMapper.selectJdataList(jdata);
    				if(null!=jlist && jlist.size()>0){
    					cl.setJsonstate("1");//有json数据
    					eventid_temp = catalog.getEventId();//重置查询条件，减少查询次数
        				this.updateByPrimaryKeySelective(cl);
    				}
    				
    			}else{
    				Catalogcopy catalogcopy = new Catalogcopy();
    				catalogcopy.setCataId(catalog.getCataId());
    				catalogcopy.setDepth(catalog.getDepth());
    				catalogcopy.setDmin(catalog.getDmin());
    				catalogcopy.setEventId(catalog.getEventId());
    				catalogcopy.setLat(catalog.getLat());
    				catalogcopy.setLon(catalog.getLon());
    				catalogcopy.setM(catalog.getM());
    				catalogcopy.setMl(catalog.getMl());
    				catalogcopy.setOTime(catalog.getoTime());
    				catalogcopy.setOTimeNs(catalog.getoTimeNs());
    				catalogcopy.setSaveTime(catalog.getSaveTime());
    				catalogcopy.setCataId(catalog.getCataId());
    				catalogcopy.setOperator(catalog.getOperator());
    				catalogcopy.setLocationCname(catalog.getLocationCname());
    				Jdata jdata = new Jdata();
    				jdata.setEventid(catalog.getEventId());
					List<Jdata> jlist = jdataMapper.selectJdataList(jdata);
    				if(null!=jlist && jlist.size()>0){
    					catalogcopy.setJsonstate("1");//有json数据
    					eventid_temp = catalog.getEventId();//重置查询条件，减少查询次数
    				}else{
    					catalogcopy.setJsonstate("2");//mei有json数据
    				}
    				try {
    					this.insertSelective(catalogcopy); //插入到复制表中
					} catch (Exception c) {
						// TODO: handle exception
						c.printStackTrace();
					}
    				
    				//消息队列发布
    				String message = JsonUtils.objtoJSONString(catalogcopy);
    				topicSender.send("eqimearthquake.topic", message);
    				/*try {
						Thread.sleep(1000);
					} catch (InterruptedException c1) {
						// TODO Auto-generated catch block
						c1.printStackTrace();
					}*/
    				
    				//发短信 放在这就是有地震就会发送
    				
    				Map<String,String> map = new HashMap<String,String>();
    				map.put("key", CommonUtils.GAODEKEY);
    				map.put("location",catalog.getLon()+","+catalog.getLat());
    				map.put("radius","1000");
    				map.put("extensions","all");
    				map.put("batch","false");
    				map.put("roadlevel","0");
    				String retu = HttpClientUtil.doGet("http://restapi.amap.com/v3/geocode/regeo",map);
    				String provice = retu.substring(retu.indexOf("_address")+11, retu.indexOf("addressComponent")-3);
    				if(null == provice|| provice.equals("")){
    					provice = "海外海洋";
    					catalogcopy.setLocation(provice);
    				}else{
    					catalogcopy.setLocation(catalogcopy.getLocationCname());
    				}
    				
    				Company company = companyMapper.selectByPrimaryKey(22);//测试
    				if( null!=company.getMessagecode()&& 
    						!company.getMessagecode().trim().equals("")&&
    						company.getMessagecode().trim().indexOf("6")!=-1
    						){//	不接收定制信息
    					return;
    				}
    				
    				if(!isSend( company,catalogcopy)){//不符合发短信的条件
    					return ;
    				}

    				String content="";
    				if(catalogcopy.getLocation().equals("海外海洋")){
    					 content = haiwaihaiyang(catalogcopy);//海外模板
    				}else{
    					 content = land(company,catalogcopy);//国内模板
    				}
//    				String phones = getPhones(earthquake.getCid());
    				String phones = getPhones(22,content);
    				
    				//String parm = "{\"customer\":\"北京时间2017年11月23日17时43分.\"}";
    				
    				String parm1 = "{\"customer\":\"" +content + "\"}";
    				try {
    					SendSmsResponse resp = SmsUtils.sendSms(CommonUtils.SMSKEY,phones, parm1);
    			        System.out.println("短信接口返回的数据----------------");
    			        System.out.println("Code=" + resp.getCode());
    			        System.out.println("Message=" + resp.getMessage());
    			        System.out.println("RequestId=" + resp.getRequestId());
    			        System.out.println("BizId=" + resp.getBizId());
    				} catch (Exception c) {
    					// TODO Auto-generated catch block
    					c.printStackTrace();
    				}
    			}
    		}
    	}
    }
    
  //海洋短信
  	public String haiwaihaiyang(Catalogcopy catalogcopy){
  		String content = "北京时间"
  				+ DateUtils.getStringDate(catalogcopy.getOTime()) + ",在"
  				+ catalogcopy.getLocationCname();
  		if(catalogcopy.getLat().toString().startsWith("-")){
  			content = content+"(南纬"+catalogcopy.getLat().toString().substring(1, catalogcopy.getLat().toString().length())+"度，";
		}else{
			content = content+"北纬"+catalogcopy.getLat()+"度，";
		}
  		
  		if(catalogcopy.getLon().toString().startsWith("-")){
  			content = content+"西经"+catalogcopy.getLon().toString().substring(1, catalogcopy.getLon().toString().length())+"度)发生";
		}else{
			content = content+"东经"+catalogcopy.getLon()+"度)发生";
		}
  		content = content+ catalogcopy.getM() + "级地震，震源深度约"
  				+ catalogcopy.getDepth() + "公里。";
  		return content;
  	}
  	
  	//国内短信
  	public String land(Company company, Catalogcopy catalogcopy) {
  		String content = "北京时间"
  				+ DateUtils.getStringDate(catalogcopy.getOTime()) + ",在"
  				+ catalogcopy.getLocationCname() + "(北纬" + catalogcopy.getLat()
  				+ "度，东经" + catalogcopy.getLon() + "度)发生"
  				+ catalogcopy.getM() + "级地震，震源深度约"
  				+ catalogcopy.getDepth() + "公里。";
  		/*
  		 * if( null!=company.getQuickcode()&&
  		 * !company.getQuickcode().trim().equals("")){//接受速报信息
  		 * 
  		 * }
  		 */
  		/*if (null != company.getMessagecode()
  				&& !company.getMessagecode().trim().equals("")
  				&& company.getMessagecode().trim().indexOf("1") != -1) {// 震中50公里范围平均人口密度、总人口数
  			content = content + "震中50公里范围内" + earthquake.getPeoplesum() + "。";
  		}
  		content = content + "震中10公里范围内平均海拔约" + earthquake.getDemaver() + "米。";
  		if (null != company.getMessagecode()
  				&& !company.getMessagecode().trim().equals("")
  				&& company.getMessagecode().trim().indexOf("2") != -1) {// 震中20公里范围内乡镇及村庄个数
  			content = content + "震中20公里范围内" + earthquake.getTowncount() + "。";
  		}

  		if (null != company.getMessagecode()
  				&& !company.getMessagecode().trim().equals("")
  				&& company.getMessagecode().trim().indexOf("3") != -1) {// 震区未来3天气象信息
  			content = content + "震区未来3天气象信息" + earthquake.getWeather() + "。";
  		}

  		if (null != company.getMessagecode()
  				&& !company.getMessagecode().trim().equals("")
  				&& company.getMessagecode().trim().indexOf("4") != -1) {// 震中50公里范围近期及历史最大地震及伤亡
  			content = content + "震中100公里范围内" + earthquake.getHazardcount()+ "。";
  		}*/
  		return content;
  	}
    
    /**
	 * 是否符合发短信的规则
	 * @param company
	 * @param earthquake
	 * @return
	 */
	public boolean isSend(Company company, Catalogcopy catalogcopy){
		boolean sendMes = false;//是否符合发短信的规则
		if( null!=company.getSmscode()&& 
				!company.getSmscode().trim().equals("")&&
				company.getSmscode().trim().indexOf("1")!=-1
				){//国内3.0级以上
			if(Double.valueOf(catalogcopy.getM())>=3.0 && !catalogcopy.getLocation().equals("海外海洋")){
				sendMes = true;
			}
				
		}else if( null!=company.getSmscode()&& 
				!company.getSmscode().trim().equals("")&&
				company.getSmscode().trim().indexOf("2")!=-1 &&
				company.getSmscode().trim().indexOf("1")==-1
				){//国内东部地区4.0级以上、西部地区4.5级以上
			if(Double.valueOf(catalogcopy.getM())>=4.0 
					&& Double.valueOf(catalogcopy.getLon())>105.0
					&& !catalogcopy.getLocation().equals("海外海洋")){
				sendMes = true;
			}else if(Double.valueOf(catalogcopy.getM())>=4.5 
					&& Double.valueOf(catalogcopy.getLon())<105.0
					&& !catalogcopy.getLocation().equals("海外海洋")){
				sendMes = true;
			}
		}
		if( null!=company.getSmscode()&& 
				!company.getSmscode().trim().equals("")&&
				company.getSmscode().trim().indexOf("3")!=-1
				){//国际陆地6.0级以上、海域7.0级以上
			if(Double.valueOf(catalogcopy.getM())>=6.0 
					&& catalogcopy.getLocation().equals("海外海洋")){
				sendMes = true;
			}
		}
		return sendMes;
	}
    
    
    /**
	 * 查找单位下的所有电话
	 * @param cid
	 * @return
	 */
	public String getPhones(Integer cid,String content){
		User u = new User();
		//u.setCid(earthquake.getCid());//查找该单位的人员信息
		u.setCid(cid);//测试
		u.setState("1");
		List<User> userList = userMapper.selectUserList(u);
		String phones = "";//发送的手机号
		if(null!=userList && userList.size()>0){
			for (User user : userList) {
				phones= phones+ getDecryptValue(user.getPhone())+",";
				
				MessageRecord mr = new MessageRecord();
				mr.setCid(cid);
				mr.setUid(user.getId());
				mr.setPhone(getDecryptValue(user.getPhone()));
				mr.setConten(content);
				mr.setCreatetime(new Date());
				messageRecordMapper.insertSelective(mr);
			}
			if(!phones.equals("")){
				phones =phones.substring(0, phones.length()-1);
			
			}
		}
		return phones;
	}
	
	// 解密数据
	private String getDecryptValue(String value) {
		String returnString = "";
		try {
			DesUtils des = new DesUtils();
			returnString = des.decrypt(value);
		} catch (Exception c) {
			// TODO Auto-generated catch block
			c.printStackTrace();
		}
		return returnString;
	}
}
