package com.euns.web.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class Resrc extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) {
		String url = req.getRequestURI();
		
		url = url.substring(url.indexOf("/", 1));
		
		String spath = url.substring(0, url.indexOf('/', 1));
		
		url = url.substring(url.indexOf(spath + "/"));
		
		String view = "/WEB-INF/resources" + url;
		
		// 요청파일을 알아냈으니 응답해준다.
		RequestDispatcher rd = req.getRequestDispatcher(view);
		try {
			rd.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
