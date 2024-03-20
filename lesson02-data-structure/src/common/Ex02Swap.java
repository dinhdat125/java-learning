package common;

public class Ex02Swap {
	public static void main(String[] args) {
		int x1 = 2;
		int x2 = 8;
		
		swapInt(x1, x2);
		System.out.println("x1 : "+x1);
		System.out.println("x2 : "+x2);

		Integer xo1 = 12;
		Integer xo2 = 18;
		
		swapInteger(xo1, xo2);
		System.out.println("xo1 : "+xo1);
		System.out.println("xo2 : "+xo2);
		
		CustomInteger ci1 = new CustomInteger(5);
		CustomInteger ci2 = new CustomInteger(10);
		
		swapCustomInteger(ci1, ci2);
		System.out.println("ci1 : "+ci1);
		System.out.println("ci2 : "+ci2);
	}
	
	private static void swapInt(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	private static void swapInteger(Integer a, Integer b) {
		Integer temp = a;
		a = b;
		b = temp;
	}
	
	private static void swapCustomInteger(CustomInteger a, CustomInteger b) {    
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
}
