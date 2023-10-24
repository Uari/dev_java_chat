package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleTest {
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public OracleTest() {
	
	}
	public List<Map<String,Object>> getDeptList(){
		List<Map<String,Object>> dList = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT deptno, dname, loc FROM dept");
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			dList = new ArrayList<>();
			Map<String,Object> rmap =  null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				dList.add(rmap);
			}
		} catch (SQLException se) {
			System.out.println(se.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dList;
	}
	public static void main(String[] args) {
		OracleTest ot = new OracleTest();
		List<Map<String,Object>> dList = ot.getDeptList();
		for(int i=0;i<dList.size();i++) {
			Map<String,Object> map = dList.get(i);
			System.out.println(map);
		}
	}
}
