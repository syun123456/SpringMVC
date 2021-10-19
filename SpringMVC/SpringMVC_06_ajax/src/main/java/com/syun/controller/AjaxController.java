package com.syun.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syun.pojo.User;

@RestController
public class AjaxController {
	
	@RequestMapping("/t1")
	public String test1() {
		return "hello";
	}
	
	@RequestMapping("/a1")
	public void a1(String name, HttpServletResponse resp) throws IOException {
		System.out.println("a1.name：" + name);
		if(name.equals("syun")) {
			resp.getWriter().print("true");
		}
		else {
			resp.getWriter().print("false");
		}
	}
	
	@RequestMapping("/a2")
	public String a2() throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		
		List<User> userList = new ArrayList<User>();
		
		userList.add(new User("Chen", 1, "123"));
		userList.add(new User("Shih", 2, "456"));
		userList.add(new User("Syun", 3, "789"));
		
		System.out.println(userList);
		
		String json = mapper.writeValueAsString(userList);
		
		return json;
	}
	
	@RequestMapping("/a3")
	public String a3(String name, String pwd) {
		String msg = "";
		
		if(name != null) {
			  if(name.equals("admin")) {
				  msg = "OK";
			  }
			  else {
				  msg = "Error";
			  }
		}
		
		if(pwd != null) {
			if(pwd.equals("111111")) {
				msg = "OK";
			}
			else {
				msg = "Error";
			}
		}
		
		return msg;
	}
}
