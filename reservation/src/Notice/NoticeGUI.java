package Notice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NoticeGUI extends JFrame {
	public NoticeGUI() {
		JFrame fr = new JFrame("공지사항");
		String header[] = {"번호","공지이름","작성자"};
		String contents[][]= {
				{"1","일단 아무거나","admin"}
				};// 나중에 DB로 내용 긁어와 붙이는 작업 예정
		JTable table = new JTable(contents,header);
		JScrollPane pane = new JScrollPane(table);
		
		JButton Modify = new JButton("수정");
		JButton add = new JButton("글쓰기");
		JButton delete = new JButton("삭제");
		JButton OK = new JButton("확인");
		
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
//버튼마다 각 작업 할 일 생각해서 다음주 까지 완성. DB연동계획
