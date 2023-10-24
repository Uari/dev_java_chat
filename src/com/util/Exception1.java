package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.step5.DeptManager3;

/*
 * 테스트 시나리오를 작성할 수 있다.
 * 무엇을 테스트 할 것인가?
 * 예외처리를 하는 것은 서비스의 안정화를 위한 필수 이다.
 */

public class Exception1 {

	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null; //쿼리문 스캔. select:pstmt.executeQuery(), insert|update|delete -> executeUpdate
	ResultSet rs = null;
	StringBuilder sql = null;

	public Exception1() {
		dbMgr = DBConnectionMgr.getInstance();
		System.out.println("Exception1()" + dbMgr);
		test(20);
	}

	public void test(int deptno) {
		sql = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept WHERE deptno=?");
		System.out.println("test()" + dbMgr);
		try {
			con = dbMgr.getConnection();
			System.out.println(con);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			System.out.println(rs.next());
			System.out.println(rs.isFirst());
			System.out.println(rs.next());
			//System.out.println(rs.isLast());
			
			while(rs.next()) {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//new Exception1();
		DeptManager3 dm = new DeptManager3();
		dm.getMapList();
	}
}
