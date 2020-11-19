package db;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

/**
	이 클래스는 커넥션 풀에 있는 커넥션을 이용해서 데이터베이스 작업을 할 유틸리티 클래스
	@author		전은석
	@since		2020.10.30
	@version	v.1.0
 */
public class EunsDBCP {
	// 커넥션 풀을 관리할 변수를 준비한다.
	public DataSource ds;
	/*
		이 클래스는 누군가 new 시키면
		context.xml 파일에 등록된 자원을 가지고 등록된 자원을 얻어오도록 한다.
		이처럼 context.xml 파일에 등록된 자원을 가지고 오는 기법을 JNDI 기법이라고 한다.
		JNDI : Java Naming and Directory Interface
	 */
	public EunsDBCP() {
		try {
			// 1. context.xml 파일에 등록된 자원을 알아낸다.
			InitialContext context = new InitialContext();
			// 2. 그중 필요한 자원을 얻어낸다.
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/TestDB");
			// 찾을 이름 작성 규칙
			// 	java:/comp/env/찾을이름
			// 따라서
			//	==> java:/comp/env/jdbc/TestDB
			
			// 따라서 이 작업이 완료가 되면 커넥션 풀을 찾았다는 것이 된다.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
		필요한 순간 접속을 해야 한다.
		물론 접속은 직접하는 것이 아니고 커넥션 풀이 가지고 있는 커넥션을 빌려오는 것이다.
	 */
	public Connection getCon() {
		Connection con = null;
		try {
			// 커넥션은 커넥션 풀을 관리하는 ds(DataSource) 에서 빌려온다.
			con = ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// Statement 반환해주는 함수
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	// PreparedStatement 반환해주는 함수
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	// 사용하지 않는 자원 반환해주는 함수
	public void close(Object o) {
		try {
			if(o instanceof Connection) {
				((Connection)o).close();
			} else if(o instanceof Statement) {
				((Statement)o).close();
			} else if(o instanceof PreparedStatement) {
				((PreparedStatement)o).close();
			} else if(o instanceof ResultSet) {
				((ResultSet)o).close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}










