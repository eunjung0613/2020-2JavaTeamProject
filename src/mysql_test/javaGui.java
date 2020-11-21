package mysql_test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class javaGui extends JFrame {
	public static JPanel contentPane;
	
	public javaGui() {
		
		setTitle("My Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c =getContentPane();
		c.setLayout(null);

        JLabel utime =new JLabel("Usage Time : ");
        utime.setBounds(200,30,200,100);
        c.add(utime);
        


        JLabel id = new JLabel("ID");
        id.setBounds(110,100,150,100);
        c.add(id);
        JTextField Id = new JTextField(20);
        Id.setBounds(180,120,500,50);
        c.add(Id);

        JLabel pw = new JLabel("Password");
        pw.setBounds(85,200,150,100);
        c.add(pw);
        JTextField Pw = new JTextField(20);
        Pw.setBounds(180,220,500,50);
        c.add(Pw);

        JLabel birth = new JLabel("birth(yymmdd)");
        birth.setBounds(60,300,150,100);
        c.add(birth);
        JTextField Birth = new JTextField(20);
        Birth.setBounds(180,320,500,50);
        c.add(Birth);

        JLabel n = new JLabel("Name");
        n.setBounds(90,400,150,100);
        c.add(n);
        JTextField N = new JTextField(20);
        N.setBounds(180,420,500,50);
        c.add(N);

        JLabel tn = new JLabel("Telephone Number");
        tn.setBounds(60,500,150,100);
        c.add(tn);
        JTextField Tn = new JTextField(20);
        Tn.setBounds(180,520,500,50);
        c.add(Tn);

        JLabel em =new JLabel("Email");
        em.setBounds(90,600,150,100);
        c.add(em);
        JTextField Em = new JTextField(20);
        Em.setBounds(180,620,500,50);
        c.add(Em);


        JButton confirm = new JButton("Confirm");
        confirm.setBounds(300,700,100,50);
        c.add(confirm);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(430,700,100,50);
        c.add(cancel);
        
        DAO dao = new DAO();
        
        
        
		ArrayList<String> arr = new ArrayList<String>();
	
        
        confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				String id = Id.getText();
				String password = Pw.getText();
				String name = N.getText();
				String phonenum = Tn.getText();
				String email = Em.getText();
				String birth = Birth.getText();
				String seattime = utime.getText();
				

				dao.updateData(new Data(id, password, name, phonenum, email, birth, seattime));
				Id.setText(id);
				Pw.setText(password);
				N.setText(name);
				Tn.setText(phonenum);
				Em.setText(email);
				Birth.setText(birth);
				utime.setText(seattime);
			}
		});
        
        cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
        
        
        setSize(800,800);
		setVisible(true);
		
	}
	

    public static void main(String[] args) {
	    new javaGui();
	}
}
