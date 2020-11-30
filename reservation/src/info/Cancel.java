package info;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancel extends JFrame {
	public static JPanel contentPane;

	public Cancel() {

		setTitle("Cancel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c =getContentPane();
		c.setLayout(null);

        JLabel utime =new JLabel("취소되었습니다.");
        utime.setBounds(120,60,250,150);
        c.add(utime);
        
        JButton conf = new JButton("확인"); //추가 확인 버튼 클릭시 메인으로의귀환
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
