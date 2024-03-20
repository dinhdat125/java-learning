package view.strategypattern;

public class Ex01Calculator {

	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		
		// anonymous to create an instance for interface
		System.out.println("sum strategy -> " + calc(a, b, new Strategy() {
			
			@Override
			public int process(int x, int y) {
				return x + y;
			}
		}));
		
		Strategy subStrategy = new Strategy() {
			
			@Override
			public int process(int x, int y) {
				return x - y;
			}
		};
		System.out.println("sub strategy -> " + calc(a, b, subStrategy));
		
		// from JDK 1.8 -> using 'anonymous function'
		// to create an instance for 'functional' interface
		// functional interface is interface has ONE abstract method
		// 'anonymous function' is function without name to override abstract method of functional interface
		// 'anonymous function' -> lambda expression
		Strategy mulStrategy = (int x, int y) -> {
			return x * y;
		};
		System.out.println("mul strategy -> " + calc(a, b, mulStrategy));
		
		// Strategy divStrategy = (x, y) ->  x / y;
		// if has one parameter -> delete ()
		// if has one line -> delete {}
		System.out.println("mul strategy -> " + calc(a, b, (x, y) ->  x / y));
	}
	
	// strategy: int process(a, b)
	private static int calc(int a, int b, Strategy strategy) {
		return strategy.process(a, b);
	}
}
