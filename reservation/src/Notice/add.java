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
		
		JFrame main = new JFrame("�۾���");
		JButton ok = new JButton("Ȯ��");
		JTextField title = new JTextField("����");
		JTextArea cont = new JTextArea("������ �Է��ϼ���");
		
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
				
				if(text.equals("������ �Է��ϼ���") || title2.equals("����")) {
					JOptionPane.showMessageDialog(null, "�����̳� ������ �Էµ��� �ʾҽ��ϴ�.","����!",JOptionPane.ERROR_MESSAGE);
				}else {
					int result = JOptionPane.showConfirmDialog(null,"����Ͻðڽ��ϱ�?","���Ȯ��",JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.CLOSED_OPTION) {
						//���� ��ư Ŭ���� �ƹ��ϵ� �߻����� ����.
					}
					else if(result == JOptionPane.YES_OPTION) {
						//yes��ư Ŭ���� ��� �۾� ���� DB ��� �ϴ� �۾�
						try {
							Class.forName("com.mysql.cj.jdbc.Driver"); //����̹� �ε�		
						}catch(ClassNotFoundException E) {
					         System.err.print("ClassNotFindException: ");
					      }
						try {
							conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
							System.out.println("DB ���� �Ϸ�");
							int lastnum2 = Search();
							sql = "SELECT num FROM prmodoris.Notice order by num desc limit 1";
							stmt=(Statement)conn.createStatement();
							rs=stmt.executeQuery(sql);
								sql = "insert into prmodoris.Notice VALUES ("+lastnum2+",'"+title2+"','"+text+"')";
								stmt=(Statement)conn.createStatement();
								int affect = stmt.executeUpdate(sql);
								if(affect==1) {
									JOptionPane.showMessageDialog(null, "����� �Ϸ�Ǿ����ϴ�.","��� �Ϸ�",JOptionPane.INFORMATION_MESSAGE);
								}
							}catch(SQLException e1) {
							System.out.println("����: "+e1);
						}
						new NoticeGUI();
						main.dispose();
					}
					else {
						//NO��ư Ŭ���� ���� �� ��� �ۼ�.
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
			Class.forName("com.mysql.cj.jdbc.Driver"); //����̹� �ε�		
		}catch(ClassNotFoundException E) {
	         System.err.print("ClassNotFindException: ");
	      }
		try {
			conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
			System.out.println("DB ���� �Ϸ�");
			sql = "SELECT num FROM prmodoris.Notice order by num desc limit 1";
			stmt=(Statement)conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				lastnum = rs.getInt("num");
				}
			lastnum2 = lastnum+1;
		}catch(SQLException e1) {
			System.out.println("����: "+e1);
		}return lastnum2;
	}
}
