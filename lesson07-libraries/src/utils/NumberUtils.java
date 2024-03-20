package utils;

import java.math.BigDecimal;

public class NumberUtils {

	public NumberUtils() {
	}
	
	public static BigDecimal bd(double value) {
		// c1: new BigDecimal(String)
		// c2: BigDecimal.valueOf(double)
		return new BigDecimal(String.valueOf(value));
	}
}
