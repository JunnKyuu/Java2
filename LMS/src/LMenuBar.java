import javax.swing.JMenuBar;

public class LMenuBar extends JMenuBar {
	private LFileMenu fileMenu;

	public LMenuBar() {
		this.fileMenu = new LFileMenu();
		this.add(this.fileMenu);
	}
	
	public void initialize() {}
}
