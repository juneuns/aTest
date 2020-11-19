package com.euns.web.controller.member;

import java.util.*;
import javax.servlet.http.*;

import com.euns.web.controller.*;
import com.euns.web.dao.*;
import com.euns.web.vo.*;
import com.euns.web.util.*;

public class MemberList implements EunsController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/memberList";
		
		ArrayList<String> color = W3COLOR.getList();
		MemberDao mDao = new MemberDao();
		ArrayList<MemberVO> list = mDao.getNameList();
		
		req.setAttribute("COLOR", color);
		req.setAttribute("LIST", list);
		req.setAttribute("VIEW", "memberDetail.euns");
		return view;
	}

}
