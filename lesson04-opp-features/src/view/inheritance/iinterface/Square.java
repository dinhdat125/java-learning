package view.inheritance.iinterface;

public class Square implements Shape {

	@Override
	public void paint() {
		System.out.println("Square -> paint");		
	}
	
	@Override
	public void cals() {
		System.out.println("Square -> cals");		
	}
}
