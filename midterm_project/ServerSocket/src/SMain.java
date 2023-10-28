import java.util.ArrayList;

public class SMain {
	private Skeleton skeleton;
	
	private void run() {
//		this.skeleton = new Skeleton();
//		this.skeleton.process();
		CLogin cLogin = new CLogin();
		ArrayList<String> dataList = cLogin.getUserInfo();
		for(String data: dataList) {
	    	System.out.println(data);
	    }
	}
	
	public static void main(String[] args) {
		SMain main = new SMain();
		main.run();
	}
}
