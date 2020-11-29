package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Join.*;
import Join.DBConnection;
import Notice.*;
import Seat.*;
import info.*;

public class MainGui extends JFrame {
	public MainGui() {
		JFrame fr = new JFrame("����������");
		String id = SignIn.getID();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String ND = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from prmodoris.Info where id='"+id+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ND = rs.getNString("name");
			}
			}catch(SQLException e) {
				System.out.println("����: "+e);
			}
		JLabel ID;
		ID = new JLabel(ND+"���� �α��� �ϼ̽��ϴ�.");
		JButton LogOut = new JButton("�α׾ƿ�");
		JButton Notice = new JButton("��������");
		JButton Seat = new JButton("�¼�����");
		JButton Info = new JButton("��������");
		
		
		fr.setLayout(null);
		fr.setBounds(10,10,350,350);
		fr.setVisible(true);
		
		ID.setBounds(20,20,260,40);
		LogOut.setBounds(180, 0, 100, 20);
		Notice.setBounds(50,90,200,50);
		Seat.setBounds(50, 170, 200, 50);
		Info.setBounds(50, 250, 200, 50);
		
		fr.add(ID);
		fr.add(LogOut);
		fr.add(Notice);
		fr.add(Seat);
		fr.add(Info);
		
		LogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fr.dispose();
				new SignIn();
			}
		});
		Notice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fr.dispose();
				new NoticeGUI();
			}
			
		});
		Seat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fr.dispose();
				new table();
			}
			
		});
		
		Info.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fr.dispose();
				new javaGui();
			}
			
		});
	}
}
