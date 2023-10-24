package network5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jdbc.DBConnectionMgr;

public class ChatDao {
	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberJoin mj = null;

	public ChatDao() {
		dbMgr = DBConnectionMgr.getInstance();
	}

	public ChatDao(MemberJoin mj) {
		this.mj = mj;
		dbMgr = DBConnectionMgr.getInstance();
	}

	public String login(String mem_id, String mem_pwd) {
		String nikname = null;
		String u_id = null;
		String u_pw = null;
		StringBuilder sql = new StringBuilder();
		List<Map<String, String>> list = new ArrayList<>();
		sql.append("SELECT u_id, u_pw, nikname");
		sql.append(" FROM member");
		sql.append(" WHERE u_id = ?");

		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			Map<String, String> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("u_id", rs.getString("u_id"));
				rmap.put("u_pw", rs.getString("u_pw"));
				rmap.put("nikname", rs.getString("nikname"));
			}
			u_id = rmap.get("u_id");
			u_pw = rmap.get("u_pw");
			
			if (mem_id.equals(u_id) && mem_pwd.equals(u_pw)) {
				nikname = rmap.get("nikname");
			} else {
				JOptionPane.showMessageDialog(null, "아이디나 비번이 일치하지 않습니다.", "로그인", 1);
			}

		}catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {

		}
	
		return nikname;
	}

	public void join() {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO member");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");

		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, mj.jtf_id.getText());
			pstmt.setString(2, mj.jtf_pw.getText());
			pstmt.setString(3, mj.jtf_nickName.getText());
			pstmt.setString(4, mj.jtf_name.getText());
			pstmt.setString(5, (String)mj.jcb_gender.getSelectedItem());
			pstmt.setInt(6, Integer.parseInt(mj.jtf_zipcode.getText()));
			pstmt.setString(7, mj.jtf_address.getText());

			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "회원 가입 완료!", "회원가입", 1);
			mj.dispose();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
			
		}
	}

	public boolean idcheck(JTextField jtf_id) {
		boolean idCheck = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u_id");
		sql.append(" FROM member");
		sql.append(" WHERE u_id = ?");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, jtf_id.getText());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "입력하신 아이디가 존재합니다.", "중복체크", 1);
				mj.jtf_id.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "사용하셔도 되는 아이디 입니다.", "중복체크", 1);
				idCheck = true;
			}
			
		} catch(SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idCheck;
	}
}
