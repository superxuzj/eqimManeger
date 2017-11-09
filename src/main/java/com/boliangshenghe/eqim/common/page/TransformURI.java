package com.boliangshenghe.eqim.common.page;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;
/** 
 * 根据传入的uri，在uri后面加上分页参数 
 * @author legolas 
 * 
 */  
public class TransformURI implements TemplateMethodModel{  
  
    public Object exec(List args) throws TemplateModelException {  
        String uri = (String) args.get(0);  
//        String du=AjaxUtils.getValue("debug_url");
//        if(StringUtils.equals(du, "0")){
//        	
//            String[] us=uri.split("/");
//            StringBuilder sburltemp=new StringBuilder();
//            if(us!=null && us.length>3){
//            	for (int i=0;i<us.length;i++) {
//            		
//            		if(i>2){
//            			sburltemp.append("/").append(us[i]);
//            		}
//    			}
//            }
//            uri=sburltemp.toString();
//        }
    	
        int n = uri.lastIndexOf("?");  
        if (n == -1) {  
            return uri + "?pageNo=";  
        }  
//        if (uri.lastIndexOf("?pageNo") != -1) {  
//            uri = uri.substring(0, uri.lastIndexOf("=") + 1);  
//            return uri;  
//        }

        String queryString = uri.substring(n + 1, uri.length());  
        String suburi = uri.substring(0, n + 1);  
        String[] strings = queryString.split("&");  
        Map<String, String> paramMap=new LinkedHashMap<String, String>();
        
        for (int i = 0; i < strings.length; i++) {  
            if (strings[i].startsWith("pageNo")) {  
                continue;  
            }  
           // suburi += strings[i];
            String[] strs=strings[i].split("=");
          
            	if(strs!=null && strs.length>1 && StringUtils.isNotBlank(strs[0])){
            		paramMap.put(strs[0], (strs.length>1)?strs[1]:"");
            	}
            	
            
        } 
        paramMap.put("pageNo", "");
        Set<String> keys=paramMap.keySet();
        StringBuilder sb=new StringBuilder();
        if(!keys.isEmpty()){
        	sb.append("?");
        }
  
        for (String key : keys) {
        	if(sb.toString().length()>1){
        		sb.append("&");
        	}
			sb.append(key).append("=").append(paramMap.get(key));
		}
        return sb.toString();  
    }  
      
      
      
}  