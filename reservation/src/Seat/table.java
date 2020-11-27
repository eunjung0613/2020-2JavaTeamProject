package Seat;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import Join.SignIn;
import Main.MainGui;
public class table extends JFrame{
	int [] a = {0, 0, 0, 0, 0, 0, 0, 0}; //�ڸ��� ���࿩�� 1�̸� ���� 0�̸� ���ڸ�
	String name [] = new String[8];
	
	int seatState = 0;					//���ý� �ڸ��� ����Ű�� Ŀ������
	public long time1 ;
	public long time2 ;
	public static long timeup ;
	static JLabel la = new JLabel();	// ��Ȳ ���
	JButton btn [] = new JButton [8];
	static JPanel NorthPanel;			//�ڼ� ��ư GUI
	static JPanel SouthPanel;			//���� ��ư GUI
	
	
	public table() {
		NorthPanel NP = new NorthPanel();
		SouthPanel SP = new SouthPanel();
		setTitle("ContentPane�� Jframe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(5,5));
		c.setBackground(Color.GRAY);
		c.add(NP, BorderLayout.CENTER);
		c.add(SP, BorderLayout.SOUTH);
		c.add(la, BorderLayout.EAST);
		setSize(800,800);
		setVisible(true);
	}
		
	class NorthPanel extends JPanel {
			public NorthPanel() {
				
				setLayout(new GridLayout(2,4));
				btn[0] = new JButton("1");
				btn[0].addActionListener(new MyActionListener());
				btn[0].setBackground(Color.WHITE);
				add(btn[0]);
				btn[1] = new JButton("2");
				btn[1].addActionListener(new MyActionListener());
				btn[1].setBackground(Color.WHITE);
				add(btn[1]);
				btn[2] = new JButton("3");
				btn[2].addActionListener(new MyActionListener());
				btn[2].setBackground(Color.WHITE);
				add(btn[2]);
				btn[3] = new JButton("4");
				btn[3].addActionListener(new MyActionListener());
				btn[3].setBackground(Color.WHITE);
				add(btn[3]);
				btn[4] = new JButton("5");
				btn[4].addActionListener(new MyActionListener());
				btn[4].setBackground(Color.WHITE);
				add(btn[4]);
				btn[5] = new JButton("6");
				btn[5].addActionListener(new MyActionListener());
				btn[5].setBackground(Color.WHITE);
				add(btn[5]);
				btn[6] = new JButton("7");
				btn[6].addActionListener(new MyActionListener());
				btn[6].setBackground(Color.WHITE);
				add(btn[6]);
				btn[7] = new JButton("8");
				btn[7].addActionListener(new MyActionListener());
				btn[7].setBackground(Color.WHITE);
				add(btn[7]);
			}
		}
		class SouthPanel extends JPanel{
			public SouthPanel() {
				setLayout(new GridLayout(1,3));
				JButton btnBook = new JButton("����");
				btnBook.addActionListener(new MyActionListener());
				add(btnBook);
				JButton btnUnBook = new JButton("�ݳ�");
				btnUnBook.addActionListener(new MyActionListener());
				add(btnUnBook);
				JButton Main = new JButton("MAIN");
				Main.addActionListener(new MyActionListener());
				add(Main);
	
			
					}
		}
	public class MyActionListener extends SignIn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			String id = SignIn.getID();
			DTO d = new DTO();
			if(b.getText().equals("1")) {
				if (a[0] == 0 ) {
					seatState=0;
					System.out.print("1");
					la.setText(seatState+1+"���ڸ�");
					btn[0].setBackground(Color.WHITE);
				}
				else if(a[0] == 1) {
					la.setText(seatState+1+"���ڸ�");
					btn[0].setBackground(Color.RED);
					seatState=0;
				
				}}
			if(b.getText().equals("2")) {
				if (a[1] == 0) {
					seatState=1;
					System.out.print("2");
					la.setText(seatState+1+"���ڸ�");
					btn[1].setBackground(Color.WHITE);
				}
				else if(a[1] == 1){
					la.setText(seatState+1+"���ڸ�");
					btn[1].setBackground(Color.RED);
					seatState=1;
				
				}}
			if(b.getText().equals("3")) {
				if (a[2] == 0) {
					seatState=2;
					System.out.print("3");
					la.setText(seatState+1+"���ڸ�");
					btn[2].setBackground(Color.WHITE);
				}
				else if(a[2] == 1){
					la.setText(seatState+1+"���ڸ�");
					btn[2].setBackground(Color.RED);
					seatState=2;
				
				}}
			if(b.getText().equals("4")) {
				if (a[3] == 0) {
					seatState=3;
					System.out.print("4");
					la.setText(seatState+1+"���ڸ�");
					btn[3].setBackground(Color.WHITE);
				}
				else if(a[3] == 1){
					la.setText(seatState+1+"���ڸ�");
					btn[3].setBackground(Color.RED);
					seatState=3;
				
				}}
			if(b.getText().equals("5")) {
				if (a[4] == 0) {
					seatState=4;
					System.out.print("5");
					la.setText(seatState+1+"���ڸ�");
					btn[4].setBackground(Color.WHITE);
				}
				else if(a[4] == 1){
					la.setText(seatState+1+"���ڸ�");
					btn[4].setBackground(Color.RED);
					seatState=4;
				
				}}
			if(b.getText().equals("6")) {
				if (a[5] == 0) {
					seatState=5;
					System.out.print("6");
					la.setText(seatState+1+"���ڸ�");
					btn[5].setBackground(Color.WHITE);
				}
				else if(a[5] == 1){
					la.setText(seatState+1+"���ڸ�");
					btn[5].setBackground(Color.RED);
					seatState=5;
				
				}}
			if(b.getText().equals("7")) {
				if (a[6] == 0) {
					seatState=6;
					System.out.print("7");
					la.setText(seatState+1+"���ڸ�");
					btn[6].setBackground(Color.WHITE);
				}
				else if(a[6] == 1){
					la.setText(seatState+1+"���ڸ�");
					btn[6].setBackground(Color.RED);
					seatState=6;
				
				}}
			if(b.getText().equals("8")) {
				if (a[7] == 0) {
					seatState=7;
					System.out.print("8");
					la.setText(seatState+1+"���ڸ�");
					btn[7].setBackground(Color.WHITE);
				}
				else if(a[7] == 1){
					la.setText(seatState+1+"���ڸ�");
					btn[7].setBackground(Color.RED);
					seatState=7;
				
				}}
			else if(b.getText().equals("����")) {			
				if (a[seatState]== 0 && name[seatState] == null) {			//seatState �ڸ��� ��������� �ʴٸ�
					a[seatState]=1;				//seatState �ڸ��� ����
					btn[seatState].setBackground(Color.RED);
					name[seatState] = id ;
					System.out.println(id);
					la.setText(seatState+1+"���ڸ� ���� �Ϸ�");
					time1 = System.currentTimeMillis ();


					}
				else if (a[seatState] == 1){
					la.setText("���� ������");

				}
			}
			else if(b.getText().equals("�ݳ�") && (name[seatState] == id)) {			//
				if (a[seatState]== 1) {
					a[seatState]=0;
					btn[seatState].setBackground(Color.white);	
					name[seatState] = null;
					la.setText(seatState+1+"���ڸ� �ݳ� �Ϸ�");
					time2 = System.currentTimeMillis ();
					timeup= time2-time1;
					timeup = (timeup/1000);
					System.out.println(timeup);
					System.out.println(id);
					d.setTime(timeup);
					d.LogingID(id);
					seatDAO a = new seatDAO();
					a.insertSeatTime(d);
					
					
}
				else if (a[seatState] == 0){
					btn[seatState].setBackground(Color.white);
					la.setText("�ݳ� �̹� �Ϸ�");
					
				}
			}
			else if(b.getText().equals("MAIN")) {			//

		}
		
	}
	}
		
	public static void setSeatTime(long time) {
		timeup=time;
	}
	public static long getseatTime() {
		timeup = (timeup/1000)/60;
		return timeup;
	}
	}


