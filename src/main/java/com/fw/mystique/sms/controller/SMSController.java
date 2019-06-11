package com.fw.mystique.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fw.mystique.sms.service.ElkService;

@RestController
public class SMSController {
	
	public static final String SUCCESS = "success";
	public static final String METHOD_PROCESSOR = "processor";
	
	@Autowired
	private ElkService elkService;
	
	@RequestMapping(value="/processor", method=RequestMethod.POST, consumes="application/json;charset=UTF-8",produces = "application/json;charset=UTF-8")
	public String processor(@RequestBody JSONObject jsonParam) {
		elkService.sendMessage(this.METHOD_PROCESSOR, jsonParam.toString());
		return this.SUCCESS;
	}
}
