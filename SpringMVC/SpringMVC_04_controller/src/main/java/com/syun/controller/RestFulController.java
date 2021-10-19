package com.syun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {
	
	@RequestMapping("/add")
	public String test1(int a, int b, Model model) { // a、b為請求時的參數 /add?a=XXX&b=XXX 
		int res = a + b;
		
		model.addAttribute("msg", "結果為" + res);
		
		return "test";
	}
	//限定/add2/3/4 用GET方式請求才能執行該方法，等同於@GetMapping註解
	//@RequestMapping(value="/add2/{a}/{b}", method=RequestMethod.GET)  請求/add2/3/4 等同於a=3、b=4，如請求/add2?a=XXX&b=XXX 會出現404錯誤
	//透過@PathVariable將網址參數帶入方法中
	@GetMapping("/add2/{a}/{b}")
	public String test2(@PathVariable int a, @PathVariable int b, Model model) { 
		int res = a + b;
		
		model.addAttribute("msg", "結果1為" + res + "，執行方法為GET");
		
		return "test";
		//return "redirect:/index.jsp" 重定向至index.jsp 使用重定向需寫完整網址
	}
	
	@PostMapping("/add2/{a}/{b}")
	public String test3(@PathVariable int a, @PathVariable int b, Model model) { 
		int res = a + b;
		
		model.addAttribute("msg", "結果2為" + res + "，執行方法為POST");
		
		return "test";
	}
}
