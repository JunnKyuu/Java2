
public class Shape {
	private int x0, y0;
	
	public void draw() {
		System.out.println(this.getClass().getTypeName());
		// 클래스가 누구인지 가져와서 아스키 코드로 찍어라.
		// 객체가 자기 클래스를 알 수 있다. C++ 같은 많은 정보들은 클래스 정보가 다 날라가는데 자바는 가져온다. 
	}
}
