package DB;
import java.sql.*;

public class DBConnection {
	Connection conn = null;
	Statement stmt = null;
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로딩		
		}catch(ClassNotFoundException e) {
	         System.err.print("ClassNotFindException: ");
	      }
		try {
			conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
			System.out.println("DB 연결 완료");
		}catch(SQLException e) {
			System.out.println("에러: "+e);
		}
	}
	
}
