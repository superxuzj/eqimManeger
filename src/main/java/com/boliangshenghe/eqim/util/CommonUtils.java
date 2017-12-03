package com.boliangshenghe.eqim.util;

import javax.servlet.http.HttpServletResponse;

/**
 * 静态常量工具类
 * @author xuzj
 *
 */
public class CommonUtils {

	//高德 key liang
	public static final String GAODEKEY = "9380c464b9a4a9ecc686cd57ff994f0c";

	public static final String SMSKEY = "64b9a4a9ec";
	public static final Integer PAGESIZE = 10;//分页 每页条数
	
	public static final String REQUEST_KEY_REQUEST = "request";// 当前请求
	
	public static final String USERID = "sessionuserid";
	public static final String USERNAME = "sessionusername";
	public static final String ISLOGIN = "islogin";
	
	//public static final String SEARCH_TIME="20171113102821.00";
	
	public static final String SEARCH_TIME="20171203051017.00";
	
	
	private static final String CACHE_CONTROL = "Cache-Control";
	private static final String PRAGMA = "Pragma";
	private static final String HTTP_NO_CACHE = "no-store,no-cache,must-revalidate";
	private static final String IE_HTTP_NO_CACHE = "post-check=0, pre-check=0";
	private static final String STANDARD_HTTP_NO_CACHE = "no-cache";
	 /**no-cache*/
    public static final void addNoCacheHeader(final HttpServletResponse response){
		response.setHeader(CACHE_CONTROL, HTTP_NO_CACHE); 
		response.addHeader(CACHE_CONTROL, IE_HTTP_NO_CACHE); 
		response.setHeader(PRAGMA, STANDARD_HTTP_NO_CACHE); 
    }
}
