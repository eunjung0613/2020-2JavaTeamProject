package DB;
import java.sql.*;

public class DBConnection {
	Connection conn = null;
	Statement stmt = null;
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //����̹� �ε�		
		}catch(ClassNotFoundException e) {
	         System.err.print("ClassNotFindException: ");
	      }
		try {
			conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
			System.out.println("DB ���� �Ϸ�");
		}catch(SQLException e) {
			System.out.println("����: "+e);
		}
	}
	
}
