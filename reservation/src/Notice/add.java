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
		JFrame main = new JFrame("�۾���");
		JButton ok = new JButton("Ȯ��");
		JTextField title = new JTextField("����");
		JTextArea cont = new JTextArea("������ �Է��ϼ���");
		
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
				int result = JOptionPane.showConfirmDialog(null,"����Ͻðڽ��ϱ�?","���Ȯ��",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					//���� ��ư Ŭ���� �ƹ��ϵ� �߻����� ����.
				}
				else if(result == JOptionPane.YES_OPTION) {
					//yes��ư Ŭ���� ��� �۾� ���� DB ��� �ϴ� �۾�
					main.dispose();
				}
				else {
					//NO��ư Ŭ���� ���� �� ��� �ۼ�.
				}
			}
			
		});
	}
	
}
