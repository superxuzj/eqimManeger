package com.boliangshenghe.eqim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.controller.base.BaseCommonController;
import com.boliangshenghe.eqim.entity.Company;
import com.boliangshenghe.eqim.entity.User;
import com.boliangshenghe.eqim.service.CompanyService;
import com.boliangshenghe.eqim.service.UserService;

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
		
		model.addAttribute("page", page);
		model.addAttribute("user", user);
		
		return "user/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			User user = userService.selectByPrimaryKey(id);
			model.addAttribute("user", user);
		}
		return "user/info";
	}

	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			User user = userService.selectByPrimaryKey(id);
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
		
		if(user.getId()!=null){
			userService.updateByPrimaryKeySelective(user);
		}else{
			userService.insertSelective(user);
		}
		
		return "redirect:/user/list";
	}
	
}
