package com.syun.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入servlet");
		
		// 獲取前端參數
		String method = req.getParameter("method");
		if(method.equals("add")) {
			req.getSession().setAttribute("msg", "執行add方法");
		}
		if(method.equals("delete")) {
			req.getSession().setAttribute("msg", "執行delete方法");
		}
		
		req.getRequestDispatcher("/jsp/test.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
