package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Join.SignIn;

public class DAO {
	Connection conn = null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement ps = null;
	
	public DAO() {
		try {
			String user = "admin"; 
			String pw = "prmodoris";
			String url = "jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB �뱶�씪�씠踰� 濡쒕뵫 �떎�뙣 : " + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB �젒�냽 �떎�뙣 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error!");
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}
	
	public void insertData(Data data) {
		try {
			String sql = "INSERT INTO Info(ID, password, name, phonenum, email, birth, seatTime) values(?, ?, ?, ?, ?, ?, ?)";
			// PrparedStatment媛앹껜 �깮�꽦, �씤�옄濡� sql臾몄씠 二쇱뼱吏�
			ps = conn.prepareStatement(sql);
			ps.setString(1, data.id);
			ps.setString(2, data.password);
			ps.setString(3, data.name);
			ps.setString(4, data.phonenum);
			ps.setString(5, data.email);
			ps.setString(6, data.birth);
			ps.setString(7, data.seattime);
			// executeUpdate : insert, delete, update�� 媛숈씠 媛믪쓣 諛쏆븘�삤吏� �븡�뒗 荑쇰━臾� �떎�뻾
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	public String[] readData() {
		String[] arr = new String[7];
		String id = SignIn.getID();
		try {
			// 荑쇰━臾몄쓣 db�뿉 �꽆源�, �삩�쟾�븳 臾몄옄�뿴 ���엯
			st = conn.createStatement();
			String sql = "SELECT * FROM Info WHERE ID='"+id+"'";

			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				for (int i = 0; i < arr.length; i++) {
					arr[i] = rs.getString(i+1);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}

	
	public void updateData(Data data) {
		try {
			String sql = "UPDATE Info SET password=?, name=?, phonenum=?, email=?, birth=?,seatTime=? WHERE ID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(7, data.id);
			ps.setString(1, data.password);
			ps.setString(2, data.name);
			ps.setString(3, data.phonenum);
			ps.setString(4, data.email);
			ps.setString(5, data.birth);
			ps.setString(6, data.seattime);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	public void deleteData(String id) {
		try {
			String sql = "DELETE FROM Info WHERE NAME=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
}
