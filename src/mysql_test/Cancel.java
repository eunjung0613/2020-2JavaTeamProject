package mysql_test;
import javax.swing.*;
import java.awt.*;

public class Cancel extends JFrame {
	public static JPanel contentPane;

	public Cancel() {

		setTitle("Cancel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c =getContentPane();
		c.setLayout(null);

        JLabel utime =new JLabel("변경이 취소되었습니다.");
        utime.setBounds(120,60,250,150);
        c.add(utime);
        
        setSize(400,300);
		setVisible(true);
        }
	
	public static void main(String[] args) {
		new Cancel();

	}

}
