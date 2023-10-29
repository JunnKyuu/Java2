import java.util.Scanner;

public class View {
	private ICLogin cLogin;
	
	public View() { this.cLogin = new CLogin(); }
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------- LOGIN ---------------\n");
		System.out.print("학번: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();
        
		cLogin.login(userId, password);
	}
}
