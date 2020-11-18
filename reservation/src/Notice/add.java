package Notice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class add extends JFrame{
	public add() {
		JFrame main = new JFrame("글쓰기");
		JButton ok = new JButton("확인");
		JTextField title = new JTextField("제목");
		JTextArea cont = new JTextArea("내용을 입력하세요");
		
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
				int result = JOptionPane.showConfirmDialog(null,"등록하시겠습니까?","등록확인",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					//닫힘 버튼 클릭시 아무일도 발생하지 않음.
				}
				else if(result == JOptionPane.YES_OPTION) {
					//yes버튼 클릭시 등록 작업 진행 DB 등록 하는 작업
					main.dispose();
				}
				else {
					//NO버튼 클릭시 쓰던 것 계속 작성.
				}
			}
			
		});
	}
	
}
