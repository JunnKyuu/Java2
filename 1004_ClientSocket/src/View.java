
public class View {
	private IControl control;
	
	public View() {
		this.control = new Control();
	}
	
	public void showUserInfo() {
		String userInfo = this.control.getUserInfo();
		System.out.println(userInfo);
	}
}
