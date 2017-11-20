package com.boliangshenghe.eqim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boliangshenghe.eqim.controller.base.BaseCommonController;
import com.boliangshenghe.eqim.entity.Smscode;
import com.boliangshenghe.eqim.service.SmscodeService;

/**
 * 短信震级CODE
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/smscode")
public class SmscodeController extends BaseCommonController{
	
	@Autowired
	private SmscodeService smscodeService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/smscode/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Smscode quickcode,Model model){
		List<Smscode> list = smscodeService.selectSmscodeList(quickcode);
		model.addAttribute("list", list);
		return "smscode/list";
	}

	
}
