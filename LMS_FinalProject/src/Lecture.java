
import java.util.StringTokenizer;

public class Lecture {
	private String name;
	private String day;
	private String time;
	private String professor;
	private String id;
	
	public Lecture(String inputString) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		if (stringTokenizer.hasMoreTokens()) this.name = stringTokenizer.nextToken();
		if (stringTokenizer.hasMoreTokens()) this.day = stringTokenizer.nextToken();
		if (stringTokenizer.hasMoreTokens()) this.time = stringTokenizer.nextToken();
		if (stringTokenizer.hasMoreTokens()) this.professor = stringTokenizer.nextToken();
		if (stringTokenizer.hasMoreTokens()) this.id = stringTokenizer.nextToken();	     
	}
	public Lecture(Object[] rowData) {
		String result = "";
		for (Object columnData : rowData) {
		    result += columnData.toString() + " ";
		}
		
		result = result.trim();
		StringTokenizer stringTokenizer = new StringTokenizer(result);
		
		if (stringTokenizer.hasMoreTokens()) this.name = stringTokenizer.nextToken();
		if (stringTokenizer.hasMoreTokens()) this.day = stringTokenizer.nextToken();
		if (stringTokenizer.hasMoreTokens()) this.time = stringTokenizer.nextToken();
		if (stringTokenizer.hasMoreTokens()) this.professor = stringTokenizer.nextToken();
		if (stringTokenizer.hasMoreTokens()) this.id = stringTokenizer.nextToken();
	}
	public String getName() { return name; }
	public String getDay() { return day; }
	public String getTime() { return time; }
	public String getProfessor() { return professor; }
	public String getId() { return id; }
}
