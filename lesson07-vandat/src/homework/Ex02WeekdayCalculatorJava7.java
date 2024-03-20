package homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static utils.DateUtils.format;

public class Ex02WeekdayCalculatorJava7 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		Date date = null;
		
		do {
			System.out.print("Enter according to the form: Day/Month/Year -> ");
			try {
				date = df.parse(ip.nextLine());
				break;
			} catch (ParseException e) {
				System.out.println("Day/Month/Year Invalid Input !");
			}
		} while (true);
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		output(c);
		
		ip.close();
	}
	
	private static void output(Calendar c) {
		String weekDay = format(c, "EEEE");
		String monthAsString = format(c, "MMMM");
		System.out.println(c.get(Calendar.DAY_OF_MONTH) + " " + (monthAsString) + " " + c.get(Calendar.YEAR) + " is a " + weekDay);
		
		int dayOfYear = c.get(Calendar.DAY_OF_YEAR);
		int remanningDays = c.getActualMaximum(Calendar.DAY_OF_YEAR) - dayOfYear;
		System.out.println("It is day number " + dayOfYear + " of the year, " + remanningDays + " day left");
		
		int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
		int weeksInYear = c.getActualMaximum(Calendar.WEEK_OF_YEAR);
		int year = c.get(Calendar.YEAR);
		System.out.println("It is " + weekDay + " number " + weekOfYear + " out of " + weeksInYear + " in " + year);
		
		int weekOfMonth = c.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		int weeksInMonth = c.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println("It is " + weekDay + " number " + weekOfMonth + " out of " + weeksInMonth + " in " 
							+ monthAsString + " " + year);
	
		System.out.println("Year " + year + " has " + c.getActualMaximum(Calendar.DAY_OF_YEAR) + " days");
		
		System.out.println(monthAsString + " " + year + " has " + c.getActualMaximum(Calendar.DAY_OF_MONTH) + " days");
	}
	
}
