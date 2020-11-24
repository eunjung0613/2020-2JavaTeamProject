package Notice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import java.sql.*;

public class add extends JFrame{
	public add() {
		
		JFrame main = new JFrame("글쓰기");
		JButton ok = new JButton("확인");
		JTextField title = new JTextField("제목");
		JTextArea cont = new JTextArea("내용을 입력하세요");
		
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
				Connection conn = null;
				String sql = null;
				ResultSet rs = null;
				Statement stmt = null;
				String text = cont.getText();
				String title2 = title.getText();
				
				if(text.equals("내용을 입력하세요") || title2.equals("제목")) {
					JOptionPane.showMessageDialog(null, "제목이나 내용이 입력되지 않았습니다.","오류!",JOptionPane.ERROR_MESSAGE);
				}else {
					int result = JOptionPane.showConfirmDialog(null,"등록하시겠습니까?","등록확인",JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.CLOSED_OPTION) {
						//닫힘 버튼 클릭시 아무일도 발생하지 않음.
					}
					else if(result == JOptionPane.YES_OPTION) {
						//yes버튼 클릭시 등록 작업 진행 DB 등록 하는 작업
						try {
							Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로딩		
						}catch(ClassNotFoundException E) {
					         System.err.print("ClassNotFindException: ");
					      }
						try {
							conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
							System.out.println("DB 연결 완료");
							int lastnum2 = Search();
							sql = "SELECT num FROM prmodoris.Notice order by num desc limit 1";
							stmt=(Statement)conn.createStatement();
							rs=stmt.executeQuery(sql);
								sql = "insert into prmodoris.Notice VALUES ("+lastnum2+",'"+title2+"','"+text+"')";
								stmt=(Statement)conn.createStatement();
								int affect = stmt.executeUpdate(sql);
								if(affect==1) {
									JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.","등록 완료",JOptionPane.INFORMATION_MESSAGE);
								}
							}catch(SQLException e1) {
							System.out.println("에러: "+e1);
						}
						new NoticeGUI();
						main.dispose();
					}
					else {
						//NO버튼 클릭시 쓰던 것 계속 작성.
					}
				}
			}});
		}
	public int Search() {
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		Statement stmt = null;
		int lastnum = 0;
		int lastnum2 = 0;
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
			while(rs.next()) {
				lastnum = rs.getInt("num");
				}
			lastnum2 = lastnum+1;
		}catch(SQLException e1) {
			System.out.println("에러: "+e1);
		}return lastnum2;
	}
}
