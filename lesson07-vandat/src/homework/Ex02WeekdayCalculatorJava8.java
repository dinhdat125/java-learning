package homework;

import static utils.DateUtils.format;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex02WeekdayCalculatorJava8 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/uuuu")
												.withResolverStyle(ResolverStyle.STRICT);
		LocalDate localDate = null;

		do {
			System.out.print("Enter according to the form: Day/Month/Year -> ");
			String input = ip.nextLine();
			try {
				localDate = LocalDate.parse(input, df);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Day/Month/Year Invalid Input !");
			}
		} while (true);
		
        output(localDate);
        
        ip.close();
	}
	
	private static void output(LocalDate localDate) {
		String weekDay = format(localDate, "EEEE");
		String monthAsString = format(localDate, "MMMM");
		System.out.println(localDate.getDayOfMonth() + " " + (monthAsString) + " " + localDate.getYear() + " is a " + weekDay);
		
		int dayOfYear = localDate.getDayOfYear();
		int remanningDays = localDate.lengthOfYear() - dayOfYear;
		System.out.println("It is day number " + dayOfYear + " of the year, " + remanningDays + " day left");
		
		//convert LocalDate -> Calendar
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        Date date = Date.from(instant);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        // test with method in LocalDate
        //int weekOfYear = localDate.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
		//long weeksInYear = localDate.range(WeekFields.ISO.weekOfWeekBasedYear()).getMaximum();
		int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
		int weeksInYear = c.getActualMaximum(Calendar.WEEK_OF_YEAR);
		int year = c.get(Calendar.YEAR);
		System.out.println("It is " + weekDay + " number " + weekOfYear + " out of " + weeksInYear + " in " + year);
		
		int weekOfMonth = c.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		int weeksInMonth = c.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println("It is " + weekDay + " number " + weekOfMonth + " out of " + weeksInMonth + " in " 
							+ monthAsString + " " + year);
	
		System.out.println("Year " + localDate.getYear() + " has " + localDate.lengthOfYear() + " days");
		
		System.out.println(monthAsString + " " + localDate.getYear() + " has " + localDate.lengthOfMonth() + " days");
	}
}
