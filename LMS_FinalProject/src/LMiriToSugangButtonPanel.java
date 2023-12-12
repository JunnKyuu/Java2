import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LMiriToSugangButtonPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JButton uButton;
    private JButton dButton;

    private LTable miridamgi;
    private LTable sugangsincheong;

    public LMiriToSugangButtonPanel() {
        ActionHandler actionHandler = new ActionHandler();

        this.setLayout(new FlowLayout());

        this.uButton = new JButton("↑");
        this.uButton.addActionListener(actionHandler);
        this.add(uButton);

        this.dButton = new JButton("↓");
        this.dButton.addActionListener(actionHandler);
        this.add(dButton);
        
        this.initialize();
    }

    public void associate(LTable miridamgi, LTable sugangsincheong) {
        this.miridamgi = miridamgi;
        this.sugangsincheong = sugangsincheong;
    }

    public void initialize() {
    }

    private void miridamgiToSugangsincheong() {
        // 미리담기 -> 수강신청
    	Lecture lecture = this.miridamgi.getLecture();
        if (lecture != null) {
            this.miridamgi.clearSelectedLecture(); 
            this.sugangsincheong.addLectures(lecture); 
        } else {
            System.out.println("null!!!");
        }
    }

    private void sugangsincheongToMiridamgi() {
        // 수강신청 -> 미리담기
        Lecture lecture = this.sugangsincheong.getLecture();
        if (lecture != null) {
            this.sugangsincheong.clearSelectedLecture(); 
            this.miridamgi.addLectures(lecture); 
        } else {
            System.out.println("null!!!");
        }
    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == dButton) {
                miridamgiToSugangsincheong();
            } else if (e.getSource() == uButton) {
                sugangsincheongToMiridamgi();
            }
        }
    }
}
