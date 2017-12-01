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

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.Company;
import com.boliangshenghe.eqim.entity.Earthquake;
import com.boliangshenghe.eqim.entity.User;
import com.boliangshenghe.eqim.service.CompanyService;
import com.boliangshenghe.eqim.service.EarthquakeService;
import com.boliangshenghe.eqim.service.UserService;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.boliangshenghe.eqim.util.HttpClientUtil;
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
			earthquakeService.updateByPrimaryKeySelective(earthquake);
		}else{
			earthquake.setCreatetime(new Date());
			earthquake.setCreator("admin");
			earthquakeService.insertSelective(earthquake);
		}
		
		if(null != earthquake.getCid() && earthquake.getCid()>0){
			Company company = companyService.selectByPrimaryKey(earthquake.getCid());//获取单位对应的配置规则
			
			if( null!=company.getMessagecode()&& 
					!company.getMessagecode().trim().equals("")&&
					company.getMessagecode().trim().indexOf("6")!=-1
					){//	不接收定制信息
				return "redirect:/earthquake/list";
			}
			
			/*String provice = retu.substring(retu.indexOf("province")+11, retu.indexOf("city")-3);
			
			if(!provice.trim().equals("")){
				String companys  = provice.substring(0, 2);
				System.out.println(companys);
			}
			System.out.println(provice+"  provice");*/
			
			User u = new User();
			u.setCid(earthquake.getCid());
			u.setState("1");
			List<User> userList = userService.selectUserList(u);
			if(null!=userList && userList.size()>0){
				for (User user : userList) {
					user.getPhone();
				}
			}
			
			
			if( null!=company.getQuickcode()&& 
				!company.getQuickcode().trim().equals("")){//接受速报信息
				
			}
			
			if( null!=company.getSmscode()&& 
					!company.getSmscode().trim().equals("")&&
					company.getSmscode().trim().indexOf("1")!=-1
					){//国内3.0级以上
					
			}else if( null!=company.getSmscode()&& 
					!company.getSmscode().trim().equals("")&&
					company.getSmscode().trim().indexOf("2")!=-1 &&
					company.getSmscode().trim().indexOf("1")==-1
					){//国内东部地区4.0级以上、西部地区4.5级以上
				
			}
			
			if( null!=company.getSmscode()&& 
					!company.getSmscode().trim().equals("")&&
					company.getSmscode().trim().indexOf("3")!=-1
					){//国际陆地6.0级以上、海域7.0级以上
					
			}
			
			if( null!=company.getMessagecode()&& 
					!company.getMessagecode().trim().equals("")&&
					company.getMessagecode().trim().indexOf("1")!=-1
					){//震中50公里范围平均人口密度、总人口数
					
			}
			
			if( null!=company.getMessagecode()&& 
					!company.getMessagecode().trim().equals("")&&
					company.getMessagecode().trim().indexOf("2")!=-1
					){//震中20公里范围内乡镇及村庄个数
					
			}
			
			if( null!=company.getMessagecode()&& 
					!company.getMessagecode().trim().equals("")&&
					company.getMessagecode().trim().indexOf("3")!=-1
					){//震区未来3天气象信息
					
			}
			
			if( null!=company.getMessagecode()&& 
					!company.getMessagecode().trim().equals("")&&
					company.getMessagecode().trim().indexOf("4")!=-1
					){//震中50公里范围近期及历史最大地震及伤亡
					
			}
		}
		return "redirect:/earthquake/list";
	}
	
	
	
}
