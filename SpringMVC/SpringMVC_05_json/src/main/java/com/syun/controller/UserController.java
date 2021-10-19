package com.syun.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syun.pojo.User;
import com.syun.utils.JsonUtils;

@Controller
// @RestController等同於下面的@ResponseBody，在類加上，下面方法就不用加@ResponseBody
public class UserController{
	
	@RequestMapping("/j1")
	@ResponseBody //不會經過視圖解析器，會停留在當前頁面，直接返回字串
	public String json1() throws JsonProcessingException{
		// json物件
		ObjectMapper mapper = new ObjectMapper();
		
		User user = new User("Syun", 18, "男");
		
		// 將字串轉為json
		String json = mapper.writeValueAsString(user);
		
		return json;
	}
	
	@RequestMapping("/j2")
	@ResponseBody
	public String json2() throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		
		List<User> userList = new ArrayList<User>();
		
		User user1 = new User("Chen", 18, "男");
		User user2 = new User("Shih", 18, "男");
		User user3 = new User("Syun", 18, "男");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		String json = mapper.writeValueAsString(userList);
		
		return json;
	}
	
	@RequestMapping("/j3")
	@ResponseBody
	public String json3() throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String json = mapper.writeValueAsString(sdf.format(date));
		
		return json;
	}
	
	@RequestMapping("/j4")
	@ResponseBody
	public String json4() throws JsonProcessingException{
		
		Date date = new Date();
		
		return JsonUtils.getJson(date);
	}
	
	@RequestMapping("/j5")
	@ResponseBody
	public String json5() throws JsonProcessingException{
		
		List<User> userList = new ArrayList<User>();
		
		User user1 = new User("Chen", 18, "男");
		User user2 = new User("Shih", 18, "男");
		User user3 = new User("Syun", 18, "男");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		return JsonUtils.getJson(userList);
	}
}
