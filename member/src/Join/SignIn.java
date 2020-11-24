package Join;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignIn extends JFrame {
	JLabel ID;
	JLabel PW;

	JTextField TID;
	JPasswordField TPW;
	
	public SignIn() {
		setTitle("자리 예약 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	GridLayout grid = new GridLayout(8,2);
	grid.setVgap(10);

	Container c = getContentPane();
	c.setLayout(grid);

	ID = new JLabel("ID");
	PW = new JLabel("PW");

	TID = new JTextField(10);
	TPW = new JPasswordField(10);
	
	String id = TID.getText();
	String password= new String(TPW.getPassword());
	
	TPW.setEchoChar('*');
		
	c.add(ID);
	c.add(TID);
	c.add(PW);
	c.add(TPW);
	
	JButton btn1 = new JButton("SIGN IN");
	add(btn1);
	btn1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		
		String id = TID.getText();
		String password = new String(TPW.getPassword());
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.SignIn(id, password);
		
		if(result == 1) {
			JOptionPane.showMessageDialog(null,"로그인이 되었습니다.","OK",JOptionPane.INFORMATION_MESSAGE);
			dispose();
			
		} else {
			JOptionPane.showMessageDialog(null,"로그인에 실패하였습니다.","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		}
	});

	JButton btn2 = new JButton("SIGN UP");
	add(btn2);
	btn2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn2 = (JButton)e.getSource();
			dispose();
			new SignUp();
		}
	});

	setSize(300, 400);
	setVisible(true);
	}
}

