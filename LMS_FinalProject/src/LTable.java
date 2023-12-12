import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class LTable extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTable table;
    private DefaultTableModel lectureTableModel;
    private Lecture selectedLecture;

    public LTable() {
        // 테이블 헤더
        String[] columns = new String[] { "강좌명", "날짜", "시간", "담당교수", "강좌번호" };

        // 테이블의 데이터
        Object[][] data = new Object[][] {};
        this.lectureTableModel = new DefaultTableModel(data, columns);
        this.table = new JTable(this.lectureTableModel);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0) {
                        Object[] rowData = data[selectedRow];
                        LTable.this.selectedLecture = new Lecture(rowData);
                    }
                }
            }
        });
        this.add(this.table);
        
        // 헤더를 추가하고 헤더의 크기를 설정
        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(350, 30));
        header.setBackground(Color.CYAN);

        // 헤더의 정렬을 가운데로 설정
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, cellRenderer);

        // 스크롤 가능한 테이블로 만들기
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(450, 135));  // 원하는 크기로 설정
        scrollPane.setMaximumSize(new Dimension(450, 135));    // 크기 제한 설정
        scrollPane.setMinimumSize(new Dimension(450, 135));    // 크기 제한 설정
        this.add(scrollPane);

        // 첫 번째 컬럼의 가로 길이를 조절
        adjustColumnWidth(0, 210);
        adjustColumnWidth(1, 60);
        adjustColumnWidth(2, 160);
        adjustColumnWidth(3, 70);
        adjustColumnWidth(4, 60);
    }

    private void adjustColumnWidth(int columnIndex, int width) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        column.setPreferredWidth(width);
    }

    public void initialize() {
    }

    // 강좌 넣고 빼는 함수 구현
    public void addLectures(Lecture lecture) {
        Object[] rowData = {
            lecture.getName(),
            lecture.getDay(),
            lecture.getTime(),
            lecture.getProfessor(),
            lecture.getId(),
        };
        this.lectureTableModel.addRow(rowData);
	    this.table.setModel(this.lectureTableModel);
    }

    public Lecture getLecture() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Object[] rowData = new Object[lectureTableModel.getColumnCount()];
            for (int i = 0; i < rowData.length; i++) {
                rowData[i] = table.getValueAt(selectedRow, i);
            }
            return new Lecture(rowData);
        }
        return null;
    }
    
    public void clearSelectedLecture() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            lectureTableModel.removeRow(selectedRow);
            this.selectedLecture = null;
        }
    }
}

