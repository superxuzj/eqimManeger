package com.boliangshenghe.eqim.service;

import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.entity.Company;

/**
 * 一些公共的方法
 * @author xuzj
 *
 */
@Service
public class CommonService {

	
	/**
	 * 判断是接受速报信息还是灾情信息
	 * 或者不收信息
	 * @param company
	 * @return
	 */
	public String isShortDetailNew(Company company){
		
		if (!company.getQuickcode().trim().equals("")
				&&!company.getMessagecode().trim().equals("") 
				&& company.getMessagecode().trim().indexOf("6")==-1) {// 接受速报信息 并且有一项灾情
			return "detail";
		}else if( !company.getQuickcode().trim().equals("")
				&&!company.getMessagecode().trim().equals("") 
				&& company.getMessagecode().trim().indexOf("6")!=-1){// 接受速报信息 不接受定制
			return "short";
		}else if(company.getQuickcode().trim().equals("")
				&&!company.getMessagecode().trim().equals("") 
				&& company.getMessagecode().trim().indexOf("6")==-1){//不接受速报 有一项灾情
			return "detail";
		}else if(!company.getQuickcode().trim().equals("")
				&&company.getMessagecode().trim().equals("")){//接受速报 没有一项灾情
			return "short";
		}else if(company.getQuickcode().trim().equals("")
				&&!company.getMessagecode().trim().equals("") 
				&& company.getMessagecode().trim().indexOf("6")!=-1){//不接受速报 也不接受灾情
			return "none";
		}else{
			return "none";
		}
	}
	
	/**
	 * 判断是接受速报信息还是灾情信息
	 * 或者不收信息
	 * @param company
	 * @return
	 */
	public String isShortDetail(Company company){
		
		if (!company.getQuickcode().trim().equals("")
				&&!company.getMessagecode().trim().equals("") 
				&& company.getMessagecode().trim().indexOf("6")==-1) {// 接受速报信息 并且有一项灾情
			return "detail";
		}else if( !company.getQuickcode().trim().equals("")
				&&!company.getMessagecode().trim().equals("") 
				&& company.getMessagecode().trim().indexOf("6")!=-1){// 接受速报信息 不接受定制
			return "short";
		}else if(company.getQuickcode().trim().equals("")
				&&!company.getMessagecode().trim().equals("") 
				&& company.getMessagecode().trim().indexOf("6")==-1){//不接受速报 有一项灾情
			return "onlydetail";
		}else if(!company.getQuickcode().trim().equals("")
				&&company.getMessagecode().trim().equals("")){//接受速报 没有一项灾情
			return "short";
		}else if(company.getQuickcode().trim().equals("")
				&&!company.getMessagecode().trim().equals("") 
				&& company.getMessagecode().trim().indexOf("6")!=-1){//不接受速报 也不接受灾情
			return "none";
		}else{
			return "none";
		}
	}
}
