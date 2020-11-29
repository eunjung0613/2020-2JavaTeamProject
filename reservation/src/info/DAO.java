package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			System.out.println("DB 드라이버 로딩 실패 : " + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속 실패 : " + sqle.toString());
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
			String sql = "INSERT INTO Info(ID, password, name, phonenum, email, birth, seattime) values(?, ?, ?, ?, ?, ?, ?)";
			// PrparedStatment객체 생성, 인자로 sql문이 주어짐
			ps = conn.prepareStatement(sql);
			ps.setString(1, data.id);
			ps.setString(2, data.password);
			ps.setString(3, data.name);
			ps.setString(4, data.phonenum);
			ps.setString(5, data.email);
			ps.setString(6, data.birth);
			ps.setString(7, data.seattime);
			// executeUpdate : insert, delete, update와 같이 값을 받아오지 않는 쿼리문 실행
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	public ArrayList<String> readData(String id) {
		ArrayList<String> arr = new ArrayList<String>();
		try {
			// 쿼리문을 db에 넘김, 온전한 문자열 대입
			String sql = "SELECT * FROM Info WHERE ID=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);

			arr.add(rs.getString(1));
			arr.add(rs.getString(2));
			arr.add(rs.getString(3));
			arr.add(rs.getString(4));
			arr.add(rs.getString(5));
			arr.add(rs.getString(6));
			arr.add(rs.getString(7));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return arr;
	}
	
	public void updateData(Data data) {
		try {
			String sql = "UPDATE Info SET password=?, name=?, phonenum=?, email=?, birth=?, seattime=? WHERE ID=?";
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
