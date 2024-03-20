package view.localdatetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static utils.DateUtils.*;

public class Ex01LocalDateDemo {

	// LocalDate -> d/M/y -> weekday, dayOfMonth ...
	//			 -> builder(advanced)
	
	public static void main(String[] args) {
		LocalDate ldate = LocalDate.now()
							.withDayOfMonth(28)
							.withMonth(8)
							.withYear(2023);
		
		LocalDate l1date = LocalDate.parse("24/10/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"))
							.plusDays(2);
		
		System.out.println("ldate -> " + format(ldate, "dd/MM/yyyy EEEE"));
		System.out.println("l1date -> " + format(l1date, "dd/MM/yyyy EEEE"));
		
		// hiệu giữa 2 localdate -> Period
		Period period = Period.between(ldate, l1date);
		System.out.println("period -> " + period);
		
		int years = period.getYears();
		int months = period.getMonths();
		int days = period.getDays();
		System.out.println("period toString -> " + optional(years, "year") 
												+ optional(months, "month")
												+ optional(days, "day"));
	}
	
	private static String format(LocalDate ldate, String pattern) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		return dtf.format(ldate);
	}
}
