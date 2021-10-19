package com.syun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ct3")
public class ControllerTest3 {
	
	@RequestMapping("/t1")
	public String test1(Model model) {
		
		model.addAttribute("msg", "ControllerTest3");
		
		return "test";
	}
}
