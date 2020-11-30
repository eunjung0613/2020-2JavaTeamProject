package info;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.MainGui;

public class javaGui extends JFrame {
	public static JPanel contentPane;
	
	public javaGui() {
		
		setTitle("My Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c =getContentPane();
		c.setLayout(null);
		
        DAO dao = new DAO();
        
        String[] arr = new String[7];
        arr = dao.readData();

        JLabel utime =new JLabel("Usage Time(min): ");
        utime.setBounds(200,30,200,100);
        c.add(utime);
        JTextField Utime = new JTextField(10);
        Utime.setBounds(300,50,100,50);
        Utime.setText(arr[6]);
        c.add(Utime);
        
        JLabel ID = new JLabel("ID");
        ID.setBounds(110,100,150,100);
        c.add(ID);
        JTextField Id = new JTextField(20);
        Id.setBounds(180,120,500,50);
        Id.setText(arr[0]);
        c.add(Id);
       
        JLabel pw = new JLabel("Password");
        pw.setBounds(85,200,150,100);
        c.add(pw);
        JTextField Pw = new JTextField(20);
        Pw.setBounds(180,220,500,50);
        Pw.setText(arr[1]);
        c.add(Pw);

        JLabel BIRTH = new JLabel("birth(yymmdd)");
        BIRTH.setBounds(60,300,150,100);
        c.add(BIRTH);
        JTextField Birth = new JTextField(20);
        Birth.setBounds(180,320,500,50);
        Birth.setText(arr[5]);
        c.add(Birth);

        JLabel n = new JLabel("Name");
        n.setBounds(90,400,150,100);
        c.add(n);
        JTextField N = new JTextField(20);
        N.setBounds(180,420,500,50);
        N.setText(arr[2]);
        c.add(N);

        JLabel tn = new JLabel("Telephone Number");
        tn.setBounds(60,500,150,100);
        c.add(tn);
        JTextField Tn = new JTextField(20);
        Tn.setBounds(180,520,500,50);
        Tn.setText(arr[3]);
        c.add(Tn);

        JLabel em =new JLabel("Email");
        em.setBounds(90,600,150,100);
        c.add(em);
        JTextField Em = new JTextField(20);
        Em.setBounds(180,620,500,50);
        Em.setText(arr[4]);
        c.add(Em);

        
        JButton confirm = new JButton("Confirm");
        confirm.setBounds(300,700,100,50);
        c.add(confirm);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(430,700,100,50);
        c.add(cancel);
	    
        confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				String id = Id.getText();
				String password = Pw.getText();
				String name = N.getText();
				String phonenum = Tn.getText();
				String email = Em.getText();
				String birth = Birth.getText();
			    String seattime = Utime.getText();
			    

				dao.updateData(new Data(id, password, name, phonenum, email, birth ,seattime));
				Id.setText(id);
				Pw.setText(password);
				N.setText(name);
				Tn.setText(phonenum);
				Em.setText(email);
				Birth.setText(birth);
				Utime.setText(seattime);
				
				OK ok = new OK();
				
				}
			
	     });
        
        cancel.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
        		new MainGui();
        	
			}
		});
        
        
        setSize(800,800);
		setVisible(true);
		
	}
}
