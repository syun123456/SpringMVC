package com.syun.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 攔截器是SpringMVC的工具，使用AOP的機制
public class MyInterceptor implements HandlerInterceptor {
	
	// 先經過這個方法，如return true，才會執行下一個程式(可能是另一個攔截器、servlet...等)
	// 一般只寫preHandle方法就好，下面兩個方法主要用來輸出攔截器日誌
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("===================執行前===================");
		
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("===================執行後===================");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("===================清理===================");
	}

}
