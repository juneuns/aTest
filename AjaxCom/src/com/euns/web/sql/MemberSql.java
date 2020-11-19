package com.euns.web.sql;

public class MemberSql {
	public final int SEL_MEMB_NAME_LIST			= 1001;
	public final int SEL_MEMB_DETAIL			= 1002;
	
	public String getSql(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_MEMB_NAME_LIST:
			buff.append("SELECT ");
			buff.append("	mno, name ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("ORDER BY ");
			buff.append("	name ");
			break;
		case SEL_MEMB_DETAIL:
			buff.append("SELECT ");
			buff.append("	mno, id, name, mail, member.gen, avt, afile avatar, joindate ");
			buff.append("FROM ");
			buff.append("	member, avatar ");
			buff.append("WHERE ");
			buff.append("	avt = ano ");
			buff.append("	AND isshow = 'Y' ");
			buff.append("	AND mno = ? ");
			break;
		}
		
		return buff.toString();
	}
}
