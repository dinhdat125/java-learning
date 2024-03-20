package common;

public class Ex03Swap {
		
	private static void swap(CustomInteger a, CustomInteger b) {    
        int temp = a.getValue();                
        a.setValue(b.getValue());                
        b.setValue(temp);                       
    }
	
	public static void main(String[] args) {
		
		CustomInteger a = new CustomInteger(5);
		CustomInteger b = new CustomInteger(10);
		
		swap(a,b);

        System.out.println("a = " + a.getValue() + " , b = " + b.getValue());
		
	}
}
