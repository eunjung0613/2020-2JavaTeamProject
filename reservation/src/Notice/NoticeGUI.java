package Notice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NoticeGUI extends JFrame {
	public NoticeGUI() {
		JFrame fr = new JFrame("��������");
		String header[] = {"��ȣ","�����̸�","�ۼ���"};
		String contents[][]= {
				{"1","�ϴ� �ƹ��ų�","admin"}
				};// ���߿� DB�� ���� �ܾ�� ���̴� �۾� ����
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
		
	}
}
//��ư���� �� �۾� �� �� �����ؼ� ������ ���� �ϼ�. DB������ȹ
