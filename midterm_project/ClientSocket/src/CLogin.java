
public class CLogin extends Stub implements ICLogin {
	// Stub을 상속받고, interface CLogin을 implement함 
	
	public CLogin() {
		super("localhost", 12345);
		// 내IP, Port Number를 썼는데 외부에서 받아서 써야함. 나중에 수정 
	}
	
	public String getUserInfo() {
		String result = this.request("cLogin", "getUserInfo", "");
		// 이것도 동적으로 만들어야함 
		// 코드를 고정시키면 안됨 
		return result;
	}
}