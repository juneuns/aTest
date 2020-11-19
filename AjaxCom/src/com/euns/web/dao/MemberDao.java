package com.euns.web.dao;

import java.sql.*;
import java.util.*;

import db.*;
import com.euns.web.sql.*;
import com.euns.web.vo.*;


public class MemberDao {
	private EunsDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MemberSql mSql;
	
	public MemberDao() {
		db = new EunsDBCP();
		mSql = new MemberSql();
	}
	
	// 회원 이름 리스트 가져오기 전담 처리함수
	public ArrayList<MemberVO> getNameList(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		con = db.getCon();
		String sql = mSql.getSql(mSql.SEL_MEMB_NAME_LIST);;
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberVO mVO = new MemberVO();
				mVO.setMno(rs.getInt("mno"));
				mVO.setName(rs.getString("name"));
				
				list.add(mVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return list;
	}
	
	// 회원 정보 가져오기 전담 처리함수
	public MemberVO getInfo(int mno) {
		MemberVO mVO = new MemberVO();
		
		con = db.getCon();
		String sql = mSql.getSql(mSql.SEL_MEMB_DETAIL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, mno);
			rs = pstmt.executeQuery();
			
			rs.next();
			mVO.setMno(rs.getInt("mno"));
			mVO.setId(rs.getString("id"));
			mVO.setName(rs.getString("name"));
			mVO.setMail(rs.getString("mail"));
			mVO.setAvt(rs.getInt("avt"));
			mVO.setAvatar(rs.getString("avatar"));
			mVO.setJoinDate(rs.getDate("joindate"));
			mVO.setJoinTime(rs.getTime("joindate"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}
}
