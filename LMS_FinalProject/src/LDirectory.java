import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class LDirectory extends JPanel {
	private static final long serialVersionUID = 1L;

	public LDirectory() {
		File rootDirectory = new File("./data"); 
		DefaultMutableTreeNode rootNode = generateChildNode(rootDirectory); 
		JTree tree = new JTree(rootNode); 
		this.add(tree); 
	}
	
	public void initialize() { }
	
	private static DefaultMutableTreeNode generateChildNode(File dir) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir.getName());
		File[] files = dir.listFiles();
		for(File file : files) {
			if (!file.getName().equals(".DS_Store")) {
                node.add(generateChildNode(file)); 
            }
		}
		return node;
	}
}
