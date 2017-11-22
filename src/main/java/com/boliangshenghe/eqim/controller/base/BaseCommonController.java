package com.boliangshenghe.eqim.controller.base;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.fastjson.JSON;
import com.boliangshenghe.eqim.util.CommonUtils;

public class BaseCommonController {

	/*@Autowired
	private DictionaryService dictionaryService;
	
	public String getDictValueByCode(String code){
		return dictionaryService.getDictvalueByCode(code);
	}*/
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
	public void maxtime(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*120);//单位为秒
	}
	
	public String getRemortIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	/**
	 * json跨域输出内容
	 */
	/**
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	protected String responseWrite(HttpServletRequest request,
			HttpServletResponse response, Object map) {
		try {	
			if(map instanceof String){
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print(map);
				response.flushBuffer();
			}else{
				String json = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd");
				Object param = request.getParameter("jsonpcallback");
				String content = json;
				if (param != null) {
					content = param + "(" + json + ")";
				}
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print(content);
				response.flushBuffer();
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	protected Integer getUserId(HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute(CommonUtils.USERID);
		return userid;
	}
	protected String getUserName(HttpServletRequest request){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute(CommonUtils.USERNAME);
		return userName;
	}
	
	protected Date stringToDate(String sourceString){
		if(sourceString==null || sourceString.equals("")){
			return null;
		}
		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式
        String nowTime=df.format(dt);//当天日期
	   	System.out.println(nowTime);
	   	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟  
	   	java.util.Date date = null;
		try {
			date = sdf.parse(nowTime+" "+sourceString+":00");
		} catch (ParseException c) {
			// TODO Auto-generated catch block
			c.printStackTrace();
		} 
	    return date;
	}
	
	protected String dateToString(Date date){
		if(date == null){
			return "";
		}
        DateFormat df = new SimpleDateFormat("HH:mm");//设置显示格式
        String nowTime=df.format(date);
        return nowTime;
	}
	
}
