package com.boliangshenghe.eqim.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.boliangshenghe.eqim.util.CommonUtils;

public class LoginFilter implements Filter{

	/**   
	* 需要排除  的页面   
	*/    
	  
	private String excludedPages;       
	private String[] excludedPageArray; 
	
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		excludedPages = config.getInitParameter("excludedPages");//不过滤的请求
		if (StringUtils.isNotEmpty(excludedPages)) {     
			excludedPageArray = excludedPages.split(",");     
		}     
		return;     
	}     

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// TODO Auto-generated method stub
		boolean isExcludedPage = false;
		//静态资源请求直接放行
		if(httpRequest.getRequestURI().indexOf("/outteamstatic")!=-1){
			 chain.doFilter(request, response);
	          return ;
    	}
        for (String page : excludedPageArray) {
            if (httpRequest.getRequestURI().indexOf(page)!=-1) {
                isExcludedPage = true;
                break;
            }
        }
        if (isExcludedPage) {//如果请求是配置中的不过滤的请求，直接放行
            chain.doFilter(request, response);
            return ;
        } 
        
        HttpSession session = httpRequest.getSession();
        
        //没有登录，需要登录
      if (session == null || 
        		session.getAttribute(CommonUtils.ISLOGIN) == null ||
        		session.getAttribute(CommonUtils.ROLEID)==null||
        		session.getAttribute(CommonUtils.USERID)==null) {
        	
            ((HttpServletResponse) response).sendRedirect(httpRequest.getContextPath()+"/login");
        } else {
            chain.doFilter(request, response);
        }
       
		
	}
	

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
