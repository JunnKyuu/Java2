import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private LMenuBar menuBar;
	private LMainPanel mainPanel;
	
	public LMainFrame() {
		// set attributes
		this.setVisible(true);
		this.setSize(600, 600);
		
		
		
		// add components
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
