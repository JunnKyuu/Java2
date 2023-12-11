import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LLRButtonPanel extends JPanel {
	// 디렉토리랑 테이블을 알아야 디렉토리에서 선택을 하면 미리담기 패널로 보낼 수 있다. 
	// Action Hanlder도 달아야한다. 
	private static final long serialVersionUID = 1L;
	
	// components - 자식들
	private JButton lButton; // 왼쪽 버튼 
	private JButton rButton; // 오른쪽 버튼

	// associations - 친구들 
	private LDirectory directory;
	private LTable table;
	
	public LLRButtonPanel() {
		ActionHandler actionHandler = new ActionHandler();
		
		this.lButton = new JButton(">>");
		this.lButton.addActionListener(actionHandler); // action handler 붙이기 
		this.add(lButton);
		
		this.rButton = new JButton("<<");
		this.rButton.addActionListener(actionHandler); // action handler 붙이기
		this.add(rButton);
	}
	
	public void associate(LDirectory directory, LTable table) {
		// 테이블로 미리담기, 수강신청이 올 수 있으므로 그냥 table로 한다. 
		this.directory = directory;
		this.table = table;
	}

	public void initialize() {
		
	}
	
	private void moveDirectoryToTable() {
		// 디렉토리 -> 미리담기
		Vector<Lecture> lectures = this.directory.getLectures(); // 강좌를 디렉토리에서 가져온다. 
		this.table.addLectures(lectures); // 강좌를 테이블로 보낸다. 
	}
	
	private void moveTableToDirectory() {
		// 테이블 -> 디렉토리 
		Vector<Lecture> lectures = this.table.getLectures(); // 강좌를 테이블에서 가져온다. 
		this.directory.addLectures(lectures); // 강좌를 디렉토리로 보낸다.
	}
	
	// ActionHandler에서 로직쓰지 않는다. 교통정리만 하면 된다. 
	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==lButton) {
				moveDirectoryToTable();
				// lButton이 눌렸을 때 디렉토리 -> 미리담기
				
			} else if(e.getSource()==rButton) {
				moveTableToDirectory();
				// rButton이 눌렸을 때 디렉토리 -> 미리담기

			}
		}
	}
}
