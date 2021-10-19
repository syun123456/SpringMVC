package com.syun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.syun.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// /user/t1?name=XXX 不加@RequestParam，name可以為空(/user/t1)
	// /user/t1?username=XXX 加@RequestParam，username不可以為空，一定要傳參數，建議一定要加上
	@RequestMapping("/t1")
	public String test1(@RequestParam("username") String name, Model model) {
		// 接收前端參數
		System.out.println("前端傳遞參數為" + name);
		
		// 返回方法處理結果給前端
		model.addAttribute("msg", "名字為" + name);
		
		return "test";
	}
	
	// 前端傳遞的參數名稱要跟User物件中的變數名一致，/user/t2?id=1&name=syun&age=18
	@RequestMapping("/t2")
	public String test2(User user) {
		// 接收前端參數
		System.out.println("前端傳遞參數為" + user);
		
		return "test";
	}
}
