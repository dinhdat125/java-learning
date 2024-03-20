package pattern.builder;

import java.math.BigDecimal;

public class Ex02BuilderDemo {
	
	public static void main(String[] args) {
		
		User1 user1 = User1.builder() // Builder(H1)
				.withId(15)           // Builder
				.withFirstName("Teo") // Builder
				.withLastName("Le")   // Builder
				.build();			  // User1
		
		User1 user2 = User1.builder()      // Builder(H2)
				.withId(18)                // Builder
				.withEmail("na@gmail.com") // Builder
				.build();
		
		User1 user3 = User1.builder()      // Builder(H3)
				.withId(22)                // Builder
				.withAddress("sw")         // Builder
				.withEmail("na@gmail.com") // Builder
				.build();
		
		System.out.println("user1 --> " + user1);
		System.out.println("user2 --> " + user2);
		System.out.println("user3 --> " + user3);
	
		//Builder pattern with costom style
		BigDecimal a = new BigDecimal(12)	//BigDecimal
				.add(bd(23))				//BigDecimal
				.subtract(bd(3));			//BigDecimal
		System.out.println("a -> " + a);
		
		BigDecimal b = BigDecimal.valueOf(22)
				.add(bd(3))
				.divide(bd(4));
		System.out.println("b -> " + b);
		
		User2 uA = new User2()				//H1
				.withId(12)					//H1
				.withEmail("teo@gmail.com");//H1
		
		User2 uB = User2.of()
				.withId(32)
				.withAge(23);
		System.out.println("uA -> " + uA );
		System.out.println("uB -> " + uB);
	}
	
	private static BigDecimal bd(double doubleValue) {
		return BigDecimal.valueOf(doubleValue);
	}
}
