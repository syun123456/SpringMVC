package com.syun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/goLogin")
	public String goLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password) {
		
		session.setAttribute("userLoginInfo", username);
		
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userLoginInfo");
		return "redirect:/index.jsp";
	}
}
