import java.io.File;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class LDirectory extends JPanel {
	private static final long serialVersionUID = 1L;

	public LDirectory() {
		// Root 디렉토리 만들기 
		File rootDirectory = new File("."); 
		
		// 트리구조 만들기 
		DefaultMutableTreeNode rootNode = generateChildNode(rootDirectory); // 먼저 root 노드를 만들기 
		JTree tree = new JTree(rootNode); // JTree 만들기 
		this.add(tree); // 루트 노트에 붙이기
	}
	
	public void initialize() { }
	
	private static DefaultMutableTreeNode generateChildNode(File dir) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir.getName());
		if(dir.isDirectory()) {
			File[] files = dir.listFiles();
			if(files != null) {
				for(File file : files) {
					node.add(generateChildNode(file)); // 자식을 붙이려고 recursion 
				}
			}
		}
		return node;
	}
}
