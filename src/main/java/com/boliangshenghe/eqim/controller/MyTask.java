package com.boliangshenghe.eqim.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.boliangshenghe.eqim.service.CatalogcopyService;

@Component
public class MyTask {
	
	@Autowired
	private CatalogcopyService catalogcopyService;

	//0 0/2 * * * ?
	//0 0/10 * * * ?
	// 0 0 0/2 * * ? *
	//5分钟一次
	@Scheduled(cron = "0 0/10 * * * ?")
	public void taskCycle() {
		// linksController.runTask();
		System.out.println("MyTask start" +new Date());
		
		catalogcopyService.insertrecordByTask();
		
	}
}
