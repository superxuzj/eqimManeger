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
import com.boliangshenghe.eqim.entity.Messagecode;
import com.boliangshenghe.eqim.entity.Quickcode;
import com.boliangshenghe.eqim.entity.Smscode;
import com.boliangshenghe.eqim.entity.User;
import com.boliangshenghe.eqim.service.CompanyService;
import com.boliangshenghe.eqim.service.MessagecodeService;
import com.boliangshenghe.eqim.service.QuickcodeService;
import com.boliangshenghe.eqim.service.SmscodeService;
import com.boliangshenghe.eqim.service.UserService;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseCommonController{
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuickcodeService quickcodeService;
	
	@Autowired
	private SmscodeService smscodeService;
	
	@Autowired
	private MessagecodeService messagecodeService;
	
	
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
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			User user = new User();
			Company company = companyService.selectByPrimaryKey(id);
			model.addAttribute("company", company);
			user.setCid(id);
			List<User> userList = userService.selectUserList(user);
			model.addAttribute("userList", userList);
		}
		
		List<Quickcode> quickcodelist = quickcodeService.selectQuickcodeList(new Quickcode());
		model.addAttribute("quickcodelist", quickcodelist);
		
		List<Smscode> smscodelist = smscodeService.selectSmscodeList(new Smscode());
		model.addAttribute("smscodelist", smscodelist);
		
		List<Messagecode> messagecodelist = messagecodeService.selectMessagecodeList(new Messagecode());
		model.addAttribute("messagecodelist", messagecodelist);
		return "company/info";
	}

	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		
		if(id!=null){
			User user = new User();
			Company company = companyService.selectByPrimaryKey(id);
			user.setCid(id);
			List<User> userList = userService.selectUserList(user);
			model.addAttribute("userList", userList);
			model.addAttribute("company", company);
		}

		List<Quickcode> quickcodelist = quickcodeService.selectQuickcodeList(new Quickcode());
		model.addAttribute("quickcodelist", quickcodelist);
		
		List<Smscode> smscodelist = smscodeService.selectSmscodeList(new Smscode());
		model.addAttribute("smscodelist", smscodelist);
		
		List<Messagecode> messagecodelist = messagecodeService.selectMessagecodeList(new Messagecode());
		model.addAttribute("messagecodelist", messagecodelist);
		
		return "company/addOrEdit";
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
  			HttpServletResponse response,Company company,Model model){
		
		if(company.getContactid()!=null){
			User user = userService.selectByPrimaryKey(company.getContactid());
			company.setContactname(user.getName());
			company.setContactphone(user.getPhone());
		}
		if(company.getLiaisonid()!=null){
			User user = userService.selectByPrimaryKey(company.getLiaisonid());
			company.setLiaisonname(user.getName());
			company.setLiaisonphone(user.getPhone());
		}
		
		if(company.getId()!=null){
			companyService.updateByPrimaryKeySelective(company);
		}else{
			companyService.insertSelective(company);
		}
		
		return "redirect:/company/list";
	}
	
	@RequestMapping("del")
	public String del(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Company company = companyService.selectByPrimaryKey(id);
			company.setState("2");
			companyService.updateByPrimaryKeySelective(company);
		}
		return "redirect:/company/list";
	}
	
}
