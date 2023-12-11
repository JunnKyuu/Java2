import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	private JMenuItem newItem;
	private JMenuItem openItem;
	
	public LFileMenu() {
		super("file");
		
		this.newItem = new JMenuItem("new");
		this.add(this.newItem);
		
		this.openItem = new JMenuItem("open");
		this.add(this.openItem);
	}
}
