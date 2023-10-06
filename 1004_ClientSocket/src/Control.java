
public class Control extends Stub implements IControl {
	
	public Control() {
		super("localhost", 12345);
	}
	
	public String getUserInfo() {
		String result = this.request("control", "getUserInfo", "");
		return result;
	}
}