
import javax.swing.JPanel;

public class LMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// 미리담기 패널, 수강신청 패널, 컨트롤 패널 2개(왼오른, 위아래)를 만들어야 한다. 
	// 버튼은 위아래, 왼오른 
	private LDirectory directory;
	private LLRButtonPanel directoryToMiridamgi; // 미리담기로 보내는 버튼, 왼오른 버튼
	private LTable miridamgi; // 미리담기와 수강신청은 같은 형식으로 만들어준다. 
	private LUDButtonPanel miridamgiToSugangsincheong;
	private LTable sugangsincheong;

	public LMainPanel() {
		// 아래와 같이 하나하나 만들어서 붙이면 된다.
		// 트리, 패널 2개, 버튼들만 만들어서 붙이면 된다.
		
		this.directory = new LDirectory(); // 디렉토리 
		this.add(this.directory);
		
		this.miridamgi = new LTable(); // 미리담기 패널 
		this.add(this.miridamgi);
		
		this.directoryToMiridamgi = new LLRButtonPanel(); // 왼오른 버튼 패널
		this.add(this.directoryToMiridamgi);
		this.directoryToMiridamgi.associate(directory, miridamgi);
		
		this.sugangsincheong = new LTable();
		this.add(this.sugangsincheong);
		
		this.miridamgiToSugangsincheong = new LUDButtonPanel();
		this.add(this.miridamgiToSugangsincheong);
		this.miridamgiToSugangsincheong.associate(sugangsincheong, miridamgi);
		
		
		
		
	}
	
	public void initialize() {
		// 자식들의 association을 만들어야 한다. 
		
		this.directoryToMiridamgi.associate(this.directory, this.miridamgi); 
		// 디렉토리에서 원하는 것을 선택하고 버튼을 클릭하면 미리담기 패널로 보내야하므로, 디렉토리, 미리담기 2개를 알아야 한다. 
		// association은 initialize에서 한다. 
		
		
		this.directory.initialize();
		this.directoryToMiridamgi.initialize();
		this.miridamgi.initialize();
		this.miridamgiToSugangsincheong.initialize();
		this.sugangsincheong.initialize();
	}
}
