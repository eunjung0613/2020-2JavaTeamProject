package javaproject;

import java.sql.*;

public class seatDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static seatDAO instance = new seatDAO();
	public static seatDAO getInstance() {
			return instance;
		}
	public int insertSeatTime(DTO Timeup) {
		conn = DBConnection.getConnection();
		
		try {
			String s = "update Info set seatTime= ? where ID= ?";
			pstmt=conn.prepareStatement(s);
			pstmt.setLong(1,Timeup.getSeatTime());
			pstmt.setString(2,Timeup.getID());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		} return -1;
	}
}


	

