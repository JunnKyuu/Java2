
import javax.swing.JPanel;

public class LMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private LDirectory directory; // 강좌를 찾을 디렉토리 
	private LMiridamgiButtonPanel directoryToMiridamgi; // 디렉토리 <-> 미리담기 
	private LTable miridamgi; // 미리담기 테이블 
	private LSugangsincheongButtonPanel directoryToSugangsincheong; // 디렉토리 <-> 수강신청 
	private LTable sugangsincheong; // 수강신청 테이블 
	private LMiriToSugangButtonPanel miridamgiToSugangsincheong; // 미리담기 <-> 수강신청

	public LMainPanel() {
		this.setLayout(null);
		
		this.directory = new LDirectory(); // 디렉토리 
		this.directory.setBounds(55, 50, 400, 460);
		this.add(this.directory);
		
		this.directoryToMiridamgi = new LMiridamgiButtonPanel(); // 디렉토리 <-> 미리담기 버튼 패널 
		this.directoryToMiridamgi.setBounds(530, 85, 80, 75);
		this.add(this.directoryToMiridamgi);
		this.directoryToMiridamgi.associate(directory, miridamgi);
		
		this.miridamgi = new LTable();  // 미리담기 테이블 
		this.miridamgi.setBounds(665, 50, 500, 150);
		this.add(this.miridamgi);
		
		this.miridamgiToSugangsincheong = new LMiriToSugangButtonPanel(); // 미리담기 <-> 수강신청 버튼 패널 
		this.miridamgiToSugangsincheong.setBounds(800, 260, 200, 40);
		this.add(this.miridamgiToSugangsincheong);
		this.miridamgiToSugangsincheong.associate(miridamgi, sugangsincheong);
		
		this.sugangsincheong = new LTable(); // 수강신청 테이블  
		this.sugangsincheong.setBounds(665, 355, 500, 150);
		this.add(this.sugangsincheong);
		
		this.directoryToSugangsincheong = new LSugangsincheongButtonPanel(); // 디렉토리 <-> 수강신청 버튼 패널 
		this.directoryToSugangsincheong.setBounds(530, 390, 80, 75);
		this.add(this.directoryToSugangsincheong);
		this.directoryToSugangsincheong.associate(directory, sugangsincheong);
	}
	
	public void initialize() {
		this.directoryToMiridamgi.associate(this.directory, this.miridamgi); 
		this.miridamgiToSugangsincheong.associate(miridamgi, sugangsincheong);
		this.directoryToSugangsincheong.associate(this.directory, this.sugangsincheong); 
		
		this.directory.initialize();
		this.directoryToMiridamgi.initialize();
		this.miridamgi.initialize();
		this.miridamgiToSugangsincheong.initialize();
		this.directoryToSugangsincheong.initialize();
		this.sugangsincheong.initialize();
	}
}
