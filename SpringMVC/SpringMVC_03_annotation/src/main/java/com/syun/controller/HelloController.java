package com.syun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/helloController") 在類加此註解，代表下面方法的網址前面需加上/helloController才能進入該方法
public class HelloController {
	
	// 請求/hello 會進入HelloController處理
	@RequestMapping("/hello")
	public String hello(Model model) { // 要轉發或重定向的網址是看return的值，而非方法名
		model.addAttribute("msg", "Hello SpringMVC Annotation!");
		
		return "hello"; // 會由視圖解析器返回/WEB-INF/jsp/hello.jsp網頁
	}
}
