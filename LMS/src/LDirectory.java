import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class LDirectory extends JPanel {
	private static final long serialVersionUID = 1L;

	public LDirectory() {
		File rootDirectory = new File("."); 
		DefaultMutableTreeNode rootNode = createDirectoryTree(rootDirectory);
		JTree tree = new JTree(rootNode);
		this.add(tree);
	}
	
	public void initialize() { }
	
	private static DefaultMutableTreeNode createDirectoryTree(File dir) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir.getName());
		if(dir.isDirectory()) {
			File[] files = dir.listFiles();
			if(files != null) {
				for(File file : files) {
					node.add(createDirectoryTree(file));
				}
			}
		}
		return node;
	}
}
