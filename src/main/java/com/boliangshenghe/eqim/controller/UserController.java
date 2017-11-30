package com.boliangshenghe.eqim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.controller.base.BaseCommonController;
import com.boliangshenghe.eqim.entity.Company;
import com.boliangshenghe.eqim.entity.User;
import com.boliangshenghe.eqim.service.CompanyService;
import com.boliangshenghe.eqim.service.UserService;
import com.boliangshenghe.eqim.util.DesUtils;

@Controller
@RequestMapping("/user")
public class UserController extends BaseCommonController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/user/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,User user,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<User> page = userService.getUserByPage(user, pageNo);
		List<User> list = page.getList();
		if(null!=list && list.size()>0){
			for (User user2 : list) {
				user2.setPhone(getDecryptValue(user2.getPhone()));
				user2.setCompany(getDecryptValue(user2.getCompany()));
				user2.setJob(getDecryptValue(user2.getJob()));
			}
		}
		List<Company> companyList = companyService.selectCompanyList(new Company());
		model.addAttribute("companyList", companyList);
		model.addAttribute("page", page);
		model.addAttribute("user", user);
		
		return "user/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			User user = userService.selectByPrimaryKey(id);
			user.setPhone(getDecryptValue(user.getPhone()));
			user.setCompany(getDecryptValue(user.getCompany()));
			user.setJob(getDecryptValue(user.getJob()));
			model.addAttribute("user", user);
		}
		return "user/info";
	}

	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			User user = userService.selectByPrimaryKey(id);
			
			user.setPhone(getDecryptValue(user.getPhone()));
			user.setCompany(getDecryptValue(user.getCompany()));
			user.setJob(getDecryptValue(user.getJob()));
			
			model.addAttribute("user", user);
		}
		
		List<Company> companyList = companyService.selectCompanyList(new Company());
		model.addAttribute("companyList", companyList);
		return "user/addOrEdit";
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
  			HttpServletResponse response,User user,Model model){
		
		if(user.getCid()!=null){
			Company company = companyService.selectByPrimaryKey(user.getCid());
			user.setCompany(company.getName());
		}
		user.setPhone(getEncryptValue(user.getPhone()));
		user.setCompany(getEncryptValue(user.getCompany()));
		user.setJob(getEncryptValue(user.getJob()));
		user.setState("1");
		if(user.getId()!=null){
			userService.updateByPrimaryKeySelective(user);
		}else{
			userService.insertSelective(user);
		}
		
		return "redirect:/user/list";
	}
	
	@RequestMapping("del")
	public String del(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			/*User user = userService.selectByPrimaryKey(id);
			user.setState("2");
			userService.updateByPrimaryKeySelective(user);*/
			userService.deleteByPrimaryKey(id);
		}
		return "redirect:/user/list";
	}
	
	@RequestMapping("valuser")
	@ResponseBody
	public String valuser(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Company contact = new Company();
			contact.setContactid(id);
			List<Company> clist = companyService.selectCompanyList(contact);
			
			if(null!=clist && clist.size()>0){
				Company company = clist.get(0);
				return company.getName();
			}
			
			Company liaison = new Company();
			liaison.setLiaisonid(id);
			List<Company> lialist =companyService.selectCompanyList(liaison);
			if(null!=lialist && lialist.size()>0){
				Company company = lialist.get(0);
				return company.getName();
			}
		}
		return "success";
	}

	// 加密数据
	private String getEncryptValue(String value) {
		String returnString = "";
		try {
			DesUtils des = new DesUtils();
			returnString = des.encrypt(value);
		} catch (Exception c) {
			// TODO Auto-generated catch block
			c.printStackTrace();
		}
		return returnString;
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
