package com.boliangshenghe.eqim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boliangshenghe.eqim.controller.base.BaseCommonController;
import com.boliangshenghe.eqim.entity.Messagecode;
import com.boliangshenghe.eqim.service.MessagecodeService;
/**
 * 灾情信息CODE
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/messagecode")
public class MessagecodeController extends BaseCommonController{
	
	@Autowired
	private MessagecodeService messagecodeService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/messagecode/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Messagecode messagecode,Model model){
		List<Messagecode> list = messagecodeService.selectMessagecodeList(messagecode);
		model.addAttribute("list", list);
		return "messagecode/list";
	}

	
}
