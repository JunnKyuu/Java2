import java.util.ArrayList;

public class CLogin extends Stub implements ICLogin {
	
	public CLogin() {
		super("localhost", 12345);
	}
	
	public ArrayList<String> getUserInfo() {
		ArrayList<String> result = this.request("CLogin", "getUserInfo", "");
        return result;
    }
		
}