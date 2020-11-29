package info;
import javax.swing.*;
import java.awt.*;
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
	        
	        setSize(400,300);
			setVisible(true);
	        }

	public static void main(String[] args) {
		new OK();

	}

}
