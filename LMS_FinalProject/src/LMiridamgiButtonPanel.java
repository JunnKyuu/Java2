
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LMiridamgiButtonPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JButton toRightButton; 
    private JButton toLeftButton; 

    private LDirectory directory;
    private LTable table;

    public LMiridamgiButtonPanel() {
        ActionHandler actionHandler = new ActionHandler();

        this.toRightButton = new JButton("→");
        this.toRightButton.addActionListener(actionHandler);
        this.add(toRightButton);

        this.toLeftButton = new JButton("←");
        this.toLeftButton.addActionListener(actionHandler);
        this.add(toLeftButton);
    }

    public void associate(LDirectory directory, LTable table) {
        this.directory = directory;
        this.table = table;
    }

    public void initialize() {
    }

    private void moveDirectoryToTable() {
        // 디렉토리 -> 미리담기
        Lecture lectures = this.directory.getLectures();
        this.table.addLectures(lectures); 
    }
    
    private void deleteLectures() {
    	// 미리담기 비우기
    	this.table.clearSelectedLecture();

    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == toRightButton) {
                moveDirectoryToTable();
            } else if (e.getSource() == toLeftButton) {
                deleteLectures();
            }
        }
    }
}

