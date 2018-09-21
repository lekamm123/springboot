package com.in28minutes.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.configration.basicConfigration;

@RestController
public class WelcomeController {

	@Autowired
	WelcomeService service;
	@RequestMapping(value ="/welcome")
	public String WelcomeMessage()
	{
		return service.welcomeServiceMessage();
	}
	
	@Autowired
	basicConfigration bcong;
	@RequestMapping(value ="/dynamicConfig")
	public Map dynamicConfigration()
	{
		Map map = new HashMap();
		
		map.put("Value", bcong.isValue());
		map.put("Message", bcong.getMessage());
		map.put("ID",bcong.getId());
		
		return map;
	}

}

