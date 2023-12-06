import javax.swing.JMenuBar;

public class LMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private LFileMenu fileMenu;

	public LMenuBar() {
		this.fileMenu = new LFileMenu();
		this.add(this.fileMenu);
	}
	
	public void initialize() {}
}
