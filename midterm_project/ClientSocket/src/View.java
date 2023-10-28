import java.util.ArrayList;

public class View {
	private ICLogin cLogin;
	
	public View() {
		this.cLogin = new CLogin();
	}
	
	public void showUserInfo() {
		ArrayList<String> userInfo = this.cLogin.getUserInfo();		
		if(userInfo.isEmpty()) {
			System.out.println("***Data is empty***");
		} else {
			System.out.println("***Data from Mysql***\n");
			for (String data : userInfo) {
	            System.out.println(data);
	        }
		}
	}
}
