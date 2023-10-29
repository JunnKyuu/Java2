
public class CLogin extends Stub implements ICLogin {
	public CLogin() { super("localhost", 12345); }
	
	public void login(String userId, String password) {
		String [] userIdPw = { userId, password };
		this.request("CLogin", "login", userIdPw);
    }
		
}