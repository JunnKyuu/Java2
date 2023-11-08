import java.rmi.Naming;
import java.rmi.RemoteException;

public class Login implements ILogin {
	// 이거는 Stub Login이다. 
	// Server의 실제 Login과 연결되어있는 통신담당이다. 
	private ILogin login;
	
	public Login() {
		// 여기서 IP를 줌 
		try {
			String url = "rmi://localhost/login";
			this.login = (ILogin) Naming.lookup(url);
			// 이런 technical한 부분이 안보이게 하려고 여기에 작성한 것이다. 
		} catch (Exception e) {
	        System.err.println("Client Exception" + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	@Override
	public String login() {
		// 여기서 Object를 줌 
		String result = null;
		try {
			result = login.login();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        System.out.println("Message from the Server: " + result); 
		return null;
	}
	
	// ILogin을 주면 위에 코드들을 자동으로 줄 수 있을까? 
	// --> interface와 IP 주소를 주면 자동으로 만들어질 수 있다.
	// Library에 MyLibrary로 만들어서 올린 후 사용하면 자동으로 만들 수 있다. 
}
