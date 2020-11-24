package Notice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import Join.SignIn;

public class NoticeGUI extends JFrame {
	public NoticeGUI() {
		

		JFrame fr = new JFrame("��������");
		String header[] = {"��ȣ","�����̸�","����"};// ���߿� DB�� ���� �ܾ�� ���̴� �۾� ����
		String NID = SignIn.getID();
		DefaultTableModel model = new DefaultTableModel(header,0);
		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps =null;
	
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.err.print("ClassNotFindException: ");
		}try {
			conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
			System.out.println("DB ���� �Ϸ�");
			String sql = "select * from prmodoris.Notice";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String memo = rs.getString("memo");

				Object data[] = {num,title,memo};
				model.addRow(data);
			}
		}catch(SQLException e) {
	         System.out.println("����: "+e);
	         }
		
		JButton Modify = new JButton("����");
		JButton add = new JButton("�۾���");
		JButton delete = new JButton("����");
		JButton OK = new JButton("Ȯ��");
		
		fr.setLayout(null);
		fr.setBounds(10, 10, 800, 800);
		fr.setVisible(true);
		
		pane.setBounds(50, 50, 700, 550);
		Modify.setBounds(80, 650, 100, 50);
		add.setBounds(260, 650, 100, 50);
		delete.setBounds(440, 650, 100, 50);
		OK.setBounds(620, 650, 100, 50);
		
		fr.add(pane);
		fr.add(add);
		fr.add(Modify);
		fr.add(delete);
		fr.add(OK);
		
		if(!NID.equals("admin")) {
			Modify.setVisible(false);
			add.setVisible(false);
			delete.setVisible(false);
		}
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fr.dispose();
				new add();
			}
		});
		
		Modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int Row = table.getSelectedRow();
				TableModel data = table.getModel();
				int monum = (int) data.getValueAt(Row, 0);
				fr.dispose();
				new Modify(monum);
			}	
		});
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","����Ȯ��",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					//���� ��ư Ŭ���� �ƹ��ϵ� �߻����� ����.
				}
				else if(result == JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					TableModel data = table.getModel();
					int deletenum = (int) data.getValueAt(row, 0);
					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement ps =null;
					try {
						Class.forName("com.mysql.cj.jdbc.Driver"); //����̹� �ε�		
					}catch(ClassNotFoundException E) {
				         System.err.print("ClassNotFindException: ");
				      }
					try {
						conn = DriverManager.getConnection("jdbc:mysql://prmodoris.c7sj6azpcoop.ap-northeast-2.rds.amazonaws.com :3306/prmodoris", "admin", "prmodoris");
						System.out.println("DB ���� �Ϸ�");
						String sql = "DELETE FROM prmodoris.Notice WHERE num = "+deletenum;
						stmt=(Statement)conn.createStatement();
						int affect = stmt.executeUpdate(sql);
							if(affect ==1) {
								JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.","���� �Ϸ�",JOptionPane.INFORMATION_MESSAGE);
							}
						}catch(SQLException e1) {
						System.out.println("����: "+e1);
					}
					fr.dispose();
				}
				else {
					//NO��ư Ŭ���� ���� �� ��� �ۼ�.
				}
			}});
		OK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int Row = table.getSelectedRow();
				TableModel data = table.getModel();
				int oknum = (int) data.getValueAt(Row, 0);
				fr.dispose();
				new OK(oknum);
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
//��ư���� �� �۾� �� �� �����ؼ� ������ ���� �ϼ�. DB������ȹ
