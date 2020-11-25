package javaproject;

import java.sql.*;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("ClassNotFindException : ");
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
			System.out.println("DB 연결 완료");
		}catch(SQLException e) {
			System.out.println("에러: " + e);
		} return conn;
	}
}
