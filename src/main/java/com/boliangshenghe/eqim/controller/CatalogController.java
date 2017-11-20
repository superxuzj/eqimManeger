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
import com.boliangshenghe.eqim.entity.Catalog;
import com.boliangshenghe.eqim.entity.Catalogcopy;
import com.boliangshenghe.eqim.service.CatalogService;
import com.boliangshenghe.eqim.service.CatalogcopyService;

@Controller
@RequestMapping("/sourcecatalog")
public class CatalogController extends BaseCommonController{
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private CatalogcopyService catalogcopyService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/sourcecatalog/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Catalog catalog,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		catalog.setEventId("20171113171939.00");
		PageBean<Catalog> page = catalogService.getCatalogByPage(catalog, pageNo);
		
		model.addAttribute("page", page);
		model.addAttribute("catalog", catalog);
		
		return "catalog/list";
	}

	
}
