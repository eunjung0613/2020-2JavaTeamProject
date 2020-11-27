package Join;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignUp extends JFrame {
	
	JLabel ID;
	JLabel PW;
	JLabel CHECK;
	JLabel NAME;
	JLabel PHONENUM;
	JLabel num1;
	JLabel num2;
	JLabel email;
	JLabel BIRTH;

	JTextField TID;
	JTextField TPW;
	JTextField TCHECK;
	JTextField TPHONENUM;
	JTextField Temail;
	JTextField TNAME;
	JTextField TBIRTH;
	
	public SignUp() {

		setTitle("SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(18,2);
		grid.setVgap(4);

		Container c = getContentPane();
		c.setLayout(grid);

		ID = new JLabel("ID");
		PW = new JLabel("PW");
		CHECK = new JLabel("CHECK");
		NAME = new JLabel("NAME");
		PHONENUM = new JLabel("PHONENUM(010-xxxx-xxxx ������� �Է����ּ���.)");
		email = new JLabel("e-mail");
		BIRTH = new JLabel("BIRTH(������� 6�ڷ� �Է����ּ���.)");
		
		TID = new JTextField(10);
		TPW = new JTextField(10);
		TCHECK = new JTextField(10);
		TNAME = new JTextField(10);
		TPHONENUM = new JTextField(10);
		Temail = new JTextField(10);
		TBIRTH = new JTextField(10);
	
		
		JButton btn0 = new JButton("IDcheck");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btn0)) {
					MemberDTO dto = new MemberDTO();
					dto.setID(TID.getText());
					MemberDao dao = MemberDao.getInstance();
					
					if(dao.getIdByCheck(TID.getText())) {
					JOptionPane.showMessageDialog(null,"��밡���� ���̵��Դϴ�.","OK",JOptionPane.INFORMATION_MESSAGE);
					} else {
						 JOptionPane.showMessageDialog(null,"�ߺ��� ���̵� �ֽ��ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);}
					}
			
			}
		});
		
		c.add(ID);
		c.add(TID);
		add(btn0);
		c.add(PW);
		c.add(TPW);
		c.add(CHECK);
		c.add(TCHECK);
		c.add(NAME);
		c.add(TNAME);
		c.add(PHONENUM);
		c.add(TPHONENUM);
		c.add(email);
		c.add(Temail);
		c.add(BIRTH);
		c.add(TBIRTH);
		
		
		JButton btn1 = new JButton("SIGN UP");
		add(btn1);
			btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//�Էµ� ���� �� ������ ������ �ϴ� ����
				if(TID.getText().trim().contentEquals("")) {
				JOptionPane.showMessageDialog(null,"���̵� �Է����� �ʾҽ��ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
				return;
				}
				
				for(int i = 0; i < TID.getText().trim().length(); i++) {
					char ch = TID.getText().trim().charAt(i);
					if(!(ch >= '0' && ch <= '9') &&! (ch >= 'a' && ch<= 'z') &&!(ch >='A' && ch <='Z')) {
					JOptionPane.showMessageDialog(null,"���̵�� ���� ��ҹ���, ���ڸ� �Է°����մϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
					}
				}
				
				if(TPW.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(null,"��й�ȣ�� �Է����� �ʾҽ��ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
					}
				
				for(int c = 0; c < TPW.getText().trim().length(); c++) {
					char chaaaa = TPW.getText().trim().charAt(c);
					if(!(chaaaa >= '0' && chaaaa <= '9') &&! (chaaaa >= 'a' && chaaaa <= 'z') &&!(chaaaa >='A' && chaaaa <='Z')) {
					JOptionPane.showMessageDialog(null,"��й�ȣ�� ���� ��ҹ���, ���ڸ� �Է°����մϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
					}
				}
				
				if(TNAME.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(null,"�̸��� �Է����� �ʾҽ��ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
					}
				if(TPHONENUM.getText().trim().contentEquals("")) {
					JOptionPane.showMessageDialog(null,"��ȭ��ȣ�� �Է����� �ʾҽ��ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for(int j = 0; j < TPHONENUM.getText().trim().length(); j++) {
					char cha = TPHONENUM.getText().trim().charAt(j);
					if(!(cha >= '0' && cha <= '9') && !(cha == '-')) {
					JOptionPane.showMessageDialog(null,"��ȭ��ȣ�� ���ڿ� -�� �Է°����մϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
					}
					
				if(Temail.getText().trim().contentEquals("")) {
				    JOptionPane.showMessageDialog(null,"������ �Է����� �ʾҽ��ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				for(int k = 0; k < Temail.getText().trim().length(); k++) {
					char chaa = Temail.getText().trim().charAt(k);
					if(!(chaa >= '0' && chaa <= '9') && !(chaa >= 'a' && chaa<= 'z') &&!(chaa >='A' && chaa <='Z') && ! (chaa == '@') && ! (chaa == '.')) {
					JOptionPane.showMessageDialog(null,"�̸����� ���� ��ҹ���, ����, @, .�� �Է°����մϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				if(TBIRTH.getText().trim().contentEquals("")) {
				JOptionPane.showMessageDialog(null,"������ �Է����� �ʾҽ��ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
				return;
				}
				
				if(TBIRTH.getText().trim().length() < 6) {
					JOptionPane.showMessageDialog(null,"������ 6�ڸ��� �Է��ϼ���.","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for(int l = 0; l < TBIRTH.getText().trim().length(); l++) {
					char chaaa = TBIRTH.getText().trim().charAt(l);
					if(!(chaaa >= '0' && chaaa <= '9')) {
					JOptionPane.showMessageDialog(null,"������ ���ڸ� �Է°����մϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
				

				//��й�ȣ�� �°� �Է� �Ǿ����� Ȯ��
				if(TPW.getText().trim().contentEquals(TCHECK.getText())) {
				
				} else {
				JOptionPane.showMessageDialog(null,"��й�ȣ�� Ʋ�Ƚ��ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
				return;
				}
				
				
			MemberDTO dto = new MemberDTO();
			dto.setID(TID.getText());
			dto.setPWD(TPW.getText());
			dto.setName(TNAME.getText());
			dto.setPhone(TPHONENUM.getText());
			dto.setMail(Temail.getText());
			dto.setBirth(TBIRTH.getText());
			
			MemberDao dao = MemberDao.getInstance();
			int result = dao.save(dto);
			
			if(result == 1) {
			 JOptionPane.showMessageDialog(null,"ȸ�������� �Ǿ����ϴ�.","OK",JOptionPane.INFORMATION_MESSAGE);
			 dispose();
			 new SignIn();
			 return;
			} else {
			  JOptionPane.showMessageDialog(null,"ȸ�����Կ� �����Ͽ����ϴ�.","ERROR",JOptionPane.ERROR_MESSAGE);
			  return;
			}
			}
				}
			}
			});

		JButton btn2 = new JButton("RETURN");
		add(btn2);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SignIn();
			}
		});
		
		setSize(400, 500);
		setVisible(true);
	}
	}

