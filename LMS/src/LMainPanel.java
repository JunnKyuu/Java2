
import javax.swing.JPanel;

public class LMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// panel 6개
	private LDirectory directory;

	public LMainPanel() {
		this.directory = new LDirectory();
		this.add(this.directory);
	}
	
	public void initialize() {}
}
