package info;
import javax.swing.*;

import Main.MainGui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class OK extends JFrame {
	
		public static JPanel contentPane;

		public OK() {

			setTitle("Sucsess");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			Container c =getContentPane();
			c.setLayout(null);

	        JLabel utime =new JLabel("변경되었습니다.");
	        utime.setBounds(150,70,250,150);
	        c.add(utime);
	        
	        JButton conf = new JButton("확인");
	        conf.setBounds(170, 230, 60, 30);
	        c.add(conf);
	        
	        setSize(400,300);
			setVisible(true);
			
			conf.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			});
	        }

}
