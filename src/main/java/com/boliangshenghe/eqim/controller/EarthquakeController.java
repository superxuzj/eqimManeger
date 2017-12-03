package com.boliangshenghe.eqim.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.Company;
import com.boliangshenghe.eqim.entity.Earthquake;
import com.boliangshenghe.eqim.entity.User;
import com.boliangshenghe.eqim.service.CompanyService;
import com.boliangshenghe.eqim.service.EarthquakeService;
import com.boliangshenghe.eqim.service.UserService;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.boliangshenghe.eqim.util.DateUtils;
import com.boliangshenghe.eqim.util.DesUtils;
import com.boliangshenghe.eqim.util.HttpClientUtil;
import com.boliangshenghe.eqim.util.SmsUtils;
/**
 * 地震事件管理
 2017
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/earthquake")
public class EarthquakeController{
	
	@Autowired
	private EarthquakeService earthquakeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/earthquake/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Earthquake earthquake,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		PageBean<Earthquake> page = earthquakeService.getEarthquakeByPage(earthquake, pageNo);
		model.addAttribute("page", page);
		model.addAttribute("earthquake", earthquake);
		
		return "earthquake/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			
		}
		return "earthquake/info";
	}
	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
			model.addAttribute("earthquake", earthquake);
		}
		List<Company> companylist = companyService.selectCompanyList(new Company());
		model.addAttribute("companylist", companylist);
		return "earthquake/addOrEdit";
	}
	
	@RequestMapping("del")
	public String del(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			 earthquakeService.deleteByPrimaryKey(id);
		}
		return "redirect:/earthquake/list";
	}
	/**
	 * 添加到数据库
	 * @param request
	 * @param response
	 * @param earthquake
	 * @param model
	 * @return
	 */
	@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,Earthquake earthquake,Model model){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("key", CommonUtils.GAODEKEY);
		map.put("location",earthquake.getLongitude()+","+earthquake.getLatitude());
		map.put("radius","1000");
		map.put("extensions","all");
		map.put("batch","false");
		map.put("roadlevel","0");
		String retu = HttpClientUtil.doGet("http://restapi.amap.com/v3/geocode/regeo",map);
		String provice = retu.substring(retu.indexOf("_address")+11, retu.indexOf("addressComponent")-3);
		if(null == provice|| provice.equals("")){
			provice = "海外海洋";
		}
		earthquake.setLocation(provice);
		
		System.out.println(earthquake.getCid()+" cid");
		
		if(earthquake.getId()!=null){
			earthquake.setCreatetime(new Date());
			earthquakeService.updateByPrimaryKeySelective(earthquake);//修改  重新选择发送单位
		}else{
			earthquake.setCreatetime(new Date());
			earthquake.setCreator("admin");
			earthquakeService.insertSelective(earthquake);//插入
		}
		
		if(null != earthquake.getCid() && earthquake.getCid()>0){
			//Company company = companyService.selectByPrimaryKey(earthquake.getCid());//获取单位对应的配置规则
			Company company = companyService.selectByPrimaryKey(22);//测试
			if( null!=company.getMessagecode()&& 
					!company.getMessagecode().trim().equals("")&&
					company.getMessagecode().trim().indexOf("6")!=-1
					){//	不接收定制信息
				return "redirect:/earthquake/list";
			}
			
			if(!isSend( company,earthquake)){//不符合发短信的条件
				return "redirect:/earthquake/list";
			}
			
//			String phones = getPhones(earthquake.getCid());
			String phones = getPhones(22);
			
			String content="";
			if(earthquake.getLocation().equals("海外海洋")){
				 content = haiwaihaiyang(earthquake);//海外模板
			}else{
				 content = land(company,earthquake);//国内模板
			}
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
		return "redirect:/earthquake/list";
	}
	
	//海洋短信
	public String haiwaihaiyang(Earthquake earthquake){
		String content = "北京时间"
				+ DateUtils.getStringDate(earthquake.getEqtime()) + ",在"
				+ earthquake.getLocation() + "(北纬" + earthquake.getLatitude()
				+ "度，东经" + earthquake.getLongitude() + "度)发生"
				+ earthquake.getMagnitude() + "级地震，震源深度约"
				+ earthquake.getDepth() + "公里。";
		return content;
	}
	
	//国内短信
	public String land(Company company, Earthquake earthquake) {
		String content = "北京时间"
				+ DateUtils.getStringDate(earthquake.getEqtime()) + ",在"
				+ earthquake.getLocation() + "(北纬" + earthquake.getLatitude()
				+ "度，东经" + earthquake.getLongitude() + "度)发生"
				+ earthquake.getMagnitude() + "级地震，震源深度约"
				+ earthquake.getDepth() + "公里。";
		/*
		 * if( null!=company.getQuickcode()&&
		 * !company.getQuickcode().trim().equals("")){//接受速报信息
		 * 
		 * }
		 */
		if (null != company.getMessagecode()
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
		}
		return content;
	}
	
	/**
	 * 是否符合发短信的规则
	 * @param company
	 * @param earthquake
	 * @return
	 */
	public boolean isSend(Company company, Earthquake earthquake){
		boolean sendMes = false;//是否符合发短信的规则
		if( null!=company.getSmscode()&& 
				!company.getSmscode().trim().equals("")&&
				company.getSmscode().trim().indexOf("1")!=-1
				){//国内3.0级以上
			if(Double.valueOf(earthquake.getMagnitude())>=3.0 && !earthquake.getLocation().equals("海外海洋")){
				sendMes = true;
			}
				
		}else if( null!=company.getSmscode()&& 
				!company.getSmscode().trim().equals("")&&
				company.getSmscode().trim().indexOf("2")!=-1 &&
				company.getSmscode().trim().indexOf("1")==-1
				){//国内东部地区4.0级以上、西部地区4.5级以上
			if(Double.valueOf(earthquake.getMagnitude())>=4.0 
					&& Double.valueOf(earthquake.getLongitude())>105.0
					&& !earthquake.getLocation().equals("海外海洋")){
				sendMes = true;
			}else if(Double.valueOf(earthquake.getMagnitude())>=4.5 
					&& Double.valueOf(earthquake.getLongitude())<105.0
					&& !earthquake.getLocation().equals("海外海洋")){
				sendMes = true;
			}
		}
		if( null!=company.getSmscode()&& 
				!company.getSmscode().trim().equals("")&&
				company.getSmscode().trim().indexOf("3")!=-1
				){//国际陆地6.0级以上、海域7.0级以上
			if(Double.valueOf(earthquake.getMagnitude())>=6.0 
					&& earthquake.getLocation().equals("海外海洋")){
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
	public String getPhones(Integer cid){
		User u = new User();
		//u.setCid(earthquake.getCid());//查找该单位的人员信息
		u.setCid(cid);//测试
		u.setState("1");
		List<User> userList = userService.selectUserList(u);
		String phones = "";//发送的手机号
		if(null!=userList && userList.size()>0){
			for (User user : userList) {
				phones= phones+ getDecryptValue(user.getPhone())+",";
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
