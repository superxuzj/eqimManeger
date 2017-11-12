package com.boliangshenghe.eqim.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boliangshenghe.eqim.controller.base.BaseCommonController;
import com.boliangshenghe.eqim.util.CommonUtils;

@Controller
public class LoginController extends BaseCommonController{
	
	
	@RequestMapping("")
    public String index(HttpServletRequest request, 
  			HttpServletResponse response) {
        return "index";
    }
	
	@RequestMapping("/index")
	public String index1(){
		return "index";
	}
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @return
	 
	@RequestMapping("")
    public String index(HttpServletRequest request, 
  			HttpServletResponse response) {
        return "redirect:/login";
    }*/
	
	/**
	 * 判断一下是否登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
    public String login(HttpServletRequest request, 
  			HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute(CommonUtils.USERID)!=null){
			return "redirect:/dologin";
		}else{
			 return "login";
		}
       
    }

	
}
