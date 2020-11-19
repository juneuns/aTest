package com.euns.web.controller.member;

import javax.servlet.http.*;

import com.euns.web.controller.*;
import com.euns.web.dao.*;
import com.euns.web.vo.*;
import com.google.gson.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

public class MemberDetail implements EunsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", null);
		
		String data = "";

		try {
			String path = req.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\img\\upload");
			MultipartRequest multi = new MultipartRequest(req, path, 1024*1024*10, "UTF-8",
					new DefaultFileRenamePolicy());
			
			// 아이디 꺼내오고
			String sno = multi.getParameter("mno");
			int mno = Integer.parseInt(sno);
			MemberDao mDao = new MemberDao();
			MemberVO mVO = mDao.getInfo(mno);
			Gson obj = new GsonBuilder().create();
			data = obj.toJson(mVO);
			resp.setCharacterEncoding("UTF-8");
		} catch(Exception e) {
			System.out.println("############ error");
		}
		return data;
	}

}
