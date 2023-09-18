
public class Main {

	private void run() {
		Shape shape;
		
		shape = new Shape();
		shape.draw();
		
		shape = new Rectangle();
		shape.draw();
			
		shape = new Oval();
		shape.draw();
		// 정적 바인딩을 위에서 shape라고 해서 타입이 다르기 때문에 오류가 발생한다.
		// 즉, 다른 타입의 인스턴스와 바인딩을 하면 오류가 발생한다. 
		// Shape의 하위 클래스에는 Rectangle만 있으므로 동적 바인딩을 하면 오류가 발생한다. 
		// 하위 클래스로 만들면 오류가 해결된다. Oval을 Shape의 한 종류로 하면 오류 해결 
		// Oval 클래스에 extends Shape을 하면 된다. 
		// 이것이 Polymorphism
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

}
