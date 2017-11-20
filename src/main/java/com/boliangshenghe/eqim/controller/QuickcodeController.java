package com.boliangshenghe.eqim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boliangshenghe.eqim.controller.base.BaseCommonController;
import com.boliangshenghe.eqim.entity.Quickcode;
import com.boliangshenghe.eqim.service.QuickcodeService;

@Controller
@RequestMapping("/quickcode")
public class QuickcodeController extends BaseCommonController{
	
	@Autowired
	private QuickcodeService quickcodeService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/quickcode/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Quickcode quickcode,Model model){
		List<Quickcode> list = quickcodeService.selectQuickcodeList(quickcode);
		model.addAttribute("list", list);
		return "quickcode/list";
	}

	
}
