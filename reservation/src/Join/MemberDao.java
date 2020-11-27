package Join;

import java.sql.*;
import java.util.Vector; 


public class MemberDao {
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
			return instance;
		}
		
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		public int SignIn(String id, String password) {
			conn = DBConnection.getConnection();
			
			try {
				String SQL = "select *from prmodoris.Info where id = ? and password = ?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return 1;
				}
				} catch(SQLException e) {
					e.printStackTrace();
				} return -1;
				
}
		public int save(MemberDTO dto) {
			conn = DBConnection.getConnection();
			
			try {
				String SQL = "insert into `Info` (id, password, name, phonenum, email, birth) values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, dto.getID());
			    pstmt.setString(2, dto.getPWD());
			    pstmt.setString(3, dto.getName());
			    pstmt.setString(4, dto.getPhone());
			    pstmt.setString(5, dto.getMail());
			    pstmt.setString(6, dto.getBirth());
			    pstmt.executeUpdate();
			    
			    return 1;
			}catch(Exception e) {
				e.printStackTrace();
			} return -1;
		}
		
		public boolean getIdByCheck(String id) {
			boolean result= true;
			conn = DBConnection.getConnection();
			
			try {
				String SQL = "select *from `Info` where id = ?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1,id);
				rs = pstmt.executeQuery();
				if(rs.next())
					result = false;
			} catch(Exception e) {
				e.printStackTrace();
			} return result;
		}

		public Vector<MemberDTO> find(){
			conn = DBConnection.getConnection();
			Vector<MemberDTO> DTO = new Vector<>();
			try {
				pstmt = conn.prepareStatement("select *from `Info`");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					MemberDTO dto = new MemberDTO();
					dto.setID(rs.getString("id"));
					dto.setPWD(rs.getString("Password"));
					DTO.add(dto);
				} return DTO;
			} catch(Exception e) {
				e.printStackTrace();
			} return null;
		}
		
}
