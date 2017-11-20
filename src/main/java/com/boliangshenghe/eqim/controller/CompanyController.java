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
import com.boliangshenghe.eqim.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseCommonController{
	
	@Autowired
	private CompanyService companyService;
	
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/company/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Company company,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<Company> page = companyService.getCompanyByPage(company, pageNo);
		
		model.addAttribute("page", page);
		model.addAttribute("company", company);
		
		return "company/list";
	}

	
}
