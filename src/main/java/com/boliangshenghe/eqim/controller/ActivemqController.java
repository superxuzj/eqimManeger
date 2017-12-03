package com.boliangshenghe.eqim.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boliangshenghe.eqim.controller.activemq.TopicSender;

/**
 * 测试activemq调用
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {
	@Resource
	TopicSender topicSender;
	
	/**
	 * 发送消息到主题
	 * 
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("topicSender")
	public String topicSender() {
		String opt = "";
		String message = "发送内容";
		try {
			topicSender.send("eqimearthquake.topic", message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}

}
