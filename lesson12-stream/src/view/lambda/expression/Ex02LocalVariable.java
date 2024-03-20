package view.lambda.expression;

import bean.Tuple;

public class Ex02LocalVariable {
	
	public static String test = "test";
	
	public static void main(String[] args) {
		Runnable r1 = testLambda_LocalVar();
		r1.run();
	}
	
	// Ex02LocalVariable              : testLambda_LocalVar # timeConsuming
	// RunningTime implements Runnable: run
	
	private static Runnable testLambda_LocalVar() {
		// Auto final with local variable
		int timeConsuming = 5;
		var tuple = new Tuple(2, 5);
		
		// external class
		// return new RunningTime(timeConsuming){
		// ...
		// };
		
		// anonymous class
		// return new Runnable(){
		// ...
		// };

		// anonymous function
		return () -> {
			// timeConsuming = 55;	error compile
			// tuple = new Tuple();
			tuple.setLeft(3);
			String taskName = "Task-R1";
			System.out.println("This " + taskName + " takes " + timeConsuming + "(s)");
			
			// But no restriction with global, static variable
			test = "lesson";
		};

	}
}