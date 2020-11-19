package com.euns.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ColorTest implements EunsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="colorTest";
		return view;
	}

}
