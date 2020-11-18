package Notice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Modify extends JFrame{
	public Modify() {
		JFrame main = new JFrame("수정");
		JButton ok = new JButton("확인");
		JTextField title = new JTextField();
		JTextArea cont = new JTextArea();
		
		main.setLayout(null);
		main.setBounds(10, 10, 800, 800);
		main.setVisible(true);
		
		title.setBounds(30, 10, 700, 30);
		cont.setBounds(30, 70, 700, 600);
		ok.setBounds(350,680,100,50);
		
		main.add(title);
		main.add(cont);
		main.add(ok);
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null,"수정하시겠습니까?","수정확인",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					
				}else if(result==JOptionPane.YES_OPTION) {
					main.dispose();
					//수정해서 DB작업
				}else {
					//사용자가 아니오 선택시 작업 없음.
				}
			}
			
		});
	}
}
