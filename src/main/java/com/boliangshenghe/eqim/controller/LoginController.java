package com.boliangshenghe.eqim.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boliangshenghe.eqim.controller.base.BaseCommonController;
import com.boliangshenghe.eqim.entity.User;
import com.boliangshenghe.eqim.entity.UserLogin;
import com.boliangshenghe.eqim.service.UserLoginService;
import com.boliangshenghe.eqim.util.CommonUtils;

@Controller
public class LoginController extends BaseCommonController{
	
	@Autowired
	private UserLoginService userLoginService;
	
	@RequestMapping("")
    public String index(HttpServletRequest request, 
  			HttpServletResponse response) {
		 return "redirect:/login";
    }
	
	@RequestMapping("/index")
	public String index1(){
		return "index";
	}

	
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

	@RequestMapping("/dologin")
	public String dologin(HttpServletRequest request, 
  			HttpServletResponse response,User user,Model model){
		
		
		return "redirect:/index";
	}
	

	 //验证用户名和密码是否正确
 	@RequestMapping("/user/validate")
 	@ResponseBody
 	public String validateNameAndPassword(HttpServletRequest request, 
 			HttpServletResponse response, String username,String password,String code) {
 		System.out.println(username+" "+password);
 		Map<String,String> map = new HashMap<String,String> ();
 		 if (!(code.equalsIgnoreCase(request.getSession().getAttribute("code").toString()))) {  //忽略验证码大小写  
 			map.put("message", "验证码错误！");  
 			return responseWrite(request, response, map);
         }
// 		HttpSession sesion = request.getSession();
 		UserLogin user = new UserLogin();
 		user.setUsername(username);
 		user.setPassword(password);
 		List<UserLogin> loginList = userLoginService.selectUserLoginList(user);
 		
 		if(loginList!=null && loginList.size()>0){
 			HttpSession session = request.getSession();
 			UserLogin usermodel = loginList.get(0);
 			session.setAttribute(CommonUtils.USERID, usermodel.getId());
 			session.setAttribute(CommonUtils.USERNAME, usermodel.getUsername());
 			session.setAttribute(CommonUtils.ISLOGIN, "OK");
 			map.put("message", "OK");
 		}else{
 			map.put("message", "用户名或密码错误！");
 		}
 		return responseWrite(request, response, map);
 	}
 	
 	
 	/**
 	 * 退出
 	 * @param request
 	 * @param response
 	 * @param user
 	 * @param model
 	 * @return
 	 */
 	@RequestMapping("/loginout")
	public String loginout(HttpServletRequest request, 
  			HttpServletResponse response,User user,Model model){
		HttpSession session = request.getSession();
		CommonUtils.addNoCacheHeader(response);
		
		session.setAttribute(CommonUtils.USERID,null);
		session.setAttribute(CommonUtils.USERNAME,null);
		
		session.setAttribute(CommonUtils.ISLOGIN,null);
		return "redirect:/login";
	}
	
}
