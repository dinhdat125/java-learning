package view;

import java.util.HashSet;
import java.util.Set;

public class Ex03 {

	public static void main(String[] args) {
		check(19);
		check(52);
		check(4);
	}
	
	private static void check(int number) {
		int sum = 0;
	    int checkNumber = number;
	    Set<Integer> visited = new HashSet<>();
	     
	    while (sum != 1 && !visited.contains(checkNumber)) {
	        visited.add(checkNumber);
	        sum = 0;
	        while (checkNumber > 0) {
	            int digit = checkNumber % 10;
	            sum += digit * digit;
	            checkNumber /= 10;
	        }
	        checkNumber = sum;
	    }
	     
	    if (sum == 1)
	    	System.out.println(number + " là số hạnh phúc");
	    else
	    	System.out.println(number + " không phải là số hạnh phúc");
	}
}
