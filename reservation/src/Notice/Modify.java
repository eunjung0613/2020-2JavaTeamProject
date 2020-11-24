package Notice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Modify extends JFrame{
	public Modify(int num) {
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		Statement stmt = null;
		DTO dto = new DTO();
		dto.setNum(num);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로딩		
		}catch(ClassNotFoundException E) {
	         System.err.print("ClassNotFindException: ");
	      }
		try {
			conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
			System.out.println("DB 연결 완료");
			sql = "SELECT * FROM prmodoris.Notice order by num="+dto.getNum();
			stmt=(Statement)conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				dto.setMemo(rs.getString("memo"));
				dto.setTitle(rs.getString("title"));
			}
		}catch(SQLException e1) {
			System.out.println("에러: "+e1);
		}
		
		JFrame main = new JFrame("수정");
		JButton ok = new JButton("확인");
		JTextField title = new JTextField(dto.getTitle());
		JTextArea cont = new JTextArea(dto.getMemo());
		
		main.setLayout(null);
		main.setBounds(10, 10, 800, 800);
		main.setVisible(true);
		
		title.setBounds(30, 10, 700, 30);
		cont.setBounds(30, 70, 700, 600);
		ok.setBounds(350,680,100,50);
		
		main.add(title);
		main.add(cont);
		main.add(ok);
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null,"수정하시겠습니까?","수정확인",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					
				}else if(result==JOptionPane.YES_OPTION) {
					Connection conn = null;
					String sql = null;
					ResultSet rs = null;
					Statement stmt = null;
					String newtitle = title.getText();
					String newMemo = cont.getText();
					dto.setTitle(newtitle);
					dto.setMemo(newMemo);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로딩		
					}catch(ClassNotFoundException E) {
				         System.err.print("ClassNotFindException: ");
				      }
					try {
						conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
						System.out.println("DB 연결 완료");
						sql = "SELECT num FROM prmodoris.Notice order by num desc limit 1";
						stmt=(Statement)conn.createStatement();
						rs=stmt.executeQuery(sql);
							sql = "update prmodoris.Notice set title='"+dto.getTitle()+"',memo='"+dto.getMemo()+"' where num="+dto.getNum();
							stmt=(Statement)conn.createStatement();
							int affect = stmt.executeUpdate(sql);
							if(affect==1) {
								JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.","수정 완료",JOptionPane.INFORMATION_MESSAGE);
							}
						}catch(SQLException e1) {
						System.out.println("에러: "+e1);
					}
					main.dispose();
					new NoticeGUI();
					
					//수정해서 DB작업
				}else {
					//사용자가 아니오 선택시 작업 없음.
				}
			}
			
		});
	}
}
