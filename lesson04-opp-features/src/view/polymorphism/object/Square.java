package view.polymorphism.object;

public class Square extends Shape {

	@Override
	void paint() {
		System.out.println("Square -> paint");
	}
	
	@Override
	void cals() {
		System.out.println("Square -> cals");
	}
	
	void setBackground() {
		System.out.println("Square -> setBackground");
	}
}
