package view.inheritance.iinterface;

public class Rectangle implements Shape, CssStyle {

	@Override
	public void paint() {
		System.out.println("Rectangle -> paint");
	}

	@Override
	public void cals() {
		System.out.println("Rectangle -> cals");
	}

	@Override
	public void setColor() {
		System.out.println("Red");		
	}

	@Override
	public void setBackground() {
		System.out.println("Black");		
	}

}
