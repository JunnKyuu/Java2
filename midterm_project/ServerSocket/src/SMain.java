
public class SMain {

	private Skeleton skeleton;
	
	private void run() {
		this.skeleton = new Skeleton();
		this.skeleton.process();
	}
	
	public static void main(String[] args) {
		SMain main = new SMain();
		main.run();
	}
}
