
public class View {
	private ICLogin cLogin;
	
	public View() {
		this.cLogin = new CLogin();
	}
	
	public void showUserInfo() {
		String userInfo = this.cLogin.getUserInfo();
		System.out.println(userInfo);
		// userInfo 받아옴 
	}
}
