package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr {
	
	static DBConnectionMgr dbMgr = null;  //왜 static인가? - 싱글톤 패턴으로 흉내내보기
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static final String _DRIVER 	= "oracle.jdbc.driver.OracleDriver";
	public static final String _url 	= "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	public static final String _user 	= "scott";
	public static final String _pw 		= "tiger";
	
	public static DBConnectionMgr getInstance() {// 공유 - 하나이다. 복제본을 만들지 않는다.
		if(dbMgr == null) {
			dbMgr = new DBConnectionMgr();
		}
		return dbMgr;
	}
	
	//리턴 타입으로 연결통로를 확보한 con을 얻는다.
	//Connection(url, 계정 정보 일치 - 인증실패, 에러코드) -> PrepareStatement(쿼리문을 전달, 처리를 요청) -> ResultSet(커서를 조작하는 메소드를 제공받음) 생성하므로
	//앞에 객체가 주입되지 않으면 나머지 뒤에는 모두 null인 상태에 놓인다.
	public Connection getConnection()
	{
		//예외처리시 try..catch블록을 사용하는데 멀티 블록이 가능함 : 단 하위에서 상위클래스로 처리함
		try {
			//각 제조사의 드라이버 클래스를 로딩하기 - ojdbc6.jar - 문자열로써 객체 주입 받아낸다. - 인터페이스가 필요함
			//그 인터페이스를 제조사가 제공해야한다. - 노출시 - 핵심기술
			Class.forName(_DRIVER); //java reflection api 공부 F/W 만들 수 있다.
			//물리적으로 떨어져있는 오라클 서버와 연결통로 확보
			//url이 존재하지 않을 경우 
			con = DriverManager.getConnection(_url,_user,_pw);
			
		} catch (ClassNotFoundException ce){
			System.out.println("ojdbc6.jar를 설정하지 않았다. 그래서 클래스를 못찾는다.");
		} catch (Exception e) {//비번이 틀린경우,
			e.printStackTrace();
		}
		return con;
	}
	//위코드에서 22번과 24번 호출 시 에러가 없다면 catch블록은 경유하지 않는다.
	
	public static void freeConnection(ResultSet rs, PreparedStatement pstmt, Connection con){
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void freeConnection(PreparedStatement pstmt, Connection con){
		try {
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void freeConnection(ResultSet rs, CallableStatement cstmt, Connection con){
		try {
			if(rs !=null) rs.close();
			if(cstmt !=null) cstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void freeConnection(CallableStatement cstmt, Connection con){
		try {
			if(cstmt !=null) cstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

