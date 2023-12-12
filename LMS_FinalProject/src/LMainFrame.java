import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private LMenuBar menuBar;
	private LMainPanel mainPanel;
	
	public LMainFrame() {
		// 속성 설정
		this.setVisible(true);
		this.setSize(1200, 600);
		
		// 컴포넌트 추가
		this.menuBar = new LMenuBar();
		this.add(this.menuBar, BorderLayout.NORTH);

		this.mainPanel = new LMainPanel();
		this.add(this.mainPanel, BorderLayout.CENTER);
	}
	
	public void initialize() {
		this.menuBar.initialize();
		this.mainPanel.initialize();
	}
}
