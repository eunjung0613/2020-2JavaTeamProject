package Notice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NoticeGUI extends JFrame {
	public NoticeGUI() {
		JFrame fr = new JFrame("��������");
		String header[] = {"��ȣ","�����̸�","�ۼ���"};
		String contents[][]= {{"1","�ƹ��ų�","test"}};// ���߿� DB�� ���� �ܾ�� ���̴� �۾� ����
		String ID="admin";
		JTable table = new JTable(contents,header);
		JScrollPane pane = new JScrollPane(table);
		
		JButton Modify = new JButton("����");
		JButton add = new JButton("�۾���");
		JButton delete = new JButton("����");
		JButton OK = new JButton("Ȯ��");
		
		fr.setLayout(null);
		fr.setBounds(10, 10, 800, 800);
		fr.setVisible(true);
		
		pane.setBounds(50, 50, 700, 550);
		Modify.setBounds(80, 650, 100, 50);
		add.setBounds(260, 650, 100, 50);
		delete.setBounds(440, 650, 100, 50);
		OK.setBounds(620, 650, 100, 50);
		
		fr.add(pane);
		fr.add(add);
		fr.add(Modify);
		fr.add(delete);
		fr.add(OK);
		
		if(!ID.equals("admin")) {
			Modify.setVisible(false);
			add.setVisible(false);
			delete.setVisible(false);
		}
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new add();
			}
		});
		
		Modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Modify();
			}	
		});
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","����Ȯ��",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					//���� ��ư Ŭ���� �ƹ��ϵ� �߻����� ����.
				}
				else if(result == JOptionPane.YES_OPTION) {
					//���� ��ư Ŭ���� ���� ���õ� ���� DB���� ����� ���� ����
				}
				else {
					//NO��ư Ŭ���� ���� �� ��� �ۼ�.
				}
			}});
		
		
	}
}
//��ư���� �� �۾� �� �� �����ؼ� ������ ���� �ϼ�. DB������ȹ
