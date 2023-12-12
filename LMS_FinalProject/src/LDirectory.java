import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class LDirectory extends JPanel {
    private static final long serialVersionUID = 1L;

    private Vector<Lecture> lectureList = new Vector<>();
    private Lecture selectedLecture;

    public LDirectory() {
        setLayout(null);
        File rootDirectory = new File("./data/명지대");
        DefaultMutableTreeNode rootNode = generateChildNode(rootDirectory);
        JTree tree = new JTree(rootNode);
        tree.setBounds(0, 0, 400, 460);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    selectedLecture = new Lecture(selectedNode.toString());
                }
            }
        });
        this.add(tree);
    }

    public void initialize() {
    }

    private DefaultMutableTreeNode generateChildNode(File dir) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir.getName());
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.getName().equals(".DS_Store")) {
                        node.add(generateChildNode(file));
                    }
                }
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(dir))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    node.add(new DefaultMutableTreeNode(line));
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return node;
    }

    // 강좌 넣고 빼는 함수 구현
    public Vector<Lecture> getAllLectures() {
        return lectureList;
    }

    public Lecture getLectures() {
        return selectedLecture;
    }

    public void addLectures(Lecture lectures) {
        lectureList.add(lectures);
    }

    // 강좌 리스트와 선택된 강좌 초기화
    public void clearLectures() {
        lectureList.clear();
        selectedLecture = null;
    }
}
