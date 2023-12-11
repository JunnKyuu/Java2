import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;

public class LTable extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTable table;
	public LTable() {
		//header
        String[] columns = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time"
        };
         
        //actual data for the table in a 2d array
        // 여기서 강좌.txt를 읽는다.
        Object[][] data = new Object[][] {
            {1, "John", 40.0, false },
            {2, "Rambo", 70.0, false },
            {3, "Zorro", 60.0, true },
        };
		
		this.table = new JTable(data, columns);
		this.add(this.table);
	}
	public void initialize() {
		
	}
	
	// 강좌 넣고 빼는 함수 구현
	public void addLectures(Vector<Lecture> lectures) {
		
	}
	public Vector<Lecture> getLectures() {
		
		return null;
	}
}
