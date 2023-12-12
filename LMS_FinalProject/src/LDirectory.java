import java.io.File;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class LDirectory extends JPanel {
	private static final long serialVersionUID = 1L;

	public LDirectory() {
		File rootDirectory = new File("./data/명지대"); 
		DefaultMutableTreeNode rootNode = generateChildNode(rootDirectory); 
		JTree tree = new JTree(rootNode); 
		this.add(tree); 
	}
	
	public void initialize() { }
	
	private DefaultMutableTreeNode generateChildNode(File dir) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir.getName());
		if(dir.isDirectory()) {
			File[] files = dir.listFiles();
			if(files != null) {
				for(File file : files) {
					node.add(generateChildNode(file)); // 자식을 붙이려고 recursion 
				}
			}
		} else {
			node.add(new DefaultMutableTreeNode("test")); 
			// 이것은 디렉토리가 아니면 강좌.txt파일이므로 한 줄씩 읽어서 노드에 붙인다. 
		}
		return node;
	}

	// 강좌 넣고 빼는 함수 구현
	public Vector<Lecture> getLectures() {
		
		return null;
	}

	public void addLectures(Vector<Lecture> lectures) {
		
	}
}
