package homework;

import static utils.DateUtils.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Ex03Java7 {

	public static void main(String[] args) {
		String zoneId = "Asia/Dubai";
		currentTime(zoneId);
		
		getLastDayOfCurrentMonth();
		
		getFirstAndLastDayOfCurrentWeek();
		
		currentDayOfWeekInYear();
		
		get20DaysLater();
		
		Date date = toDate("12/05/2000", "dd/MM/yyyy", false);
		getLifeTime(date);
	}
	
	private static void currentTime(String zoneId) {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone(zoneId));
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone(zoneId));
		Date date = c.getTime();
		System.out.println("1. The current time in " + zoneId + ": " + df.format(date));
		//System.out.println("1. The current time in " + zoneId + ": " + format(c, "dd/MM/yyyy HH:mm:ss"));
	}
	
	private static void getLastDayOfCurrentMonth() {
		Calendar c = Calendar.getInstance();
		System.out.print("2. The last day of the current month: ");
		System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH)+1) + "/"
							+ c.get(Calendar.YEAR));
	}
	
	private static void getFirstAndLastDayOfCurrentWeek() {
		Calendar c = Calendar.getInstance(new Locale("vi", "VN"));
		int duration = c.getFirstDayOfWeek() - c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? duration - 7 : duration);
		System.out.println("3. The first day of the current week: " + format(c, "dd/MM/yyyy"));
		c.add(Calendar.DAY_OF_MONTH, 6);
		System.out.println("   The last day of the current week: " + format(c, "dd/MM/yyyy"));
	}
	
	private static void currentDayOfWeekInYear() {
		Calendar c = Calendar.getInstance();
		System.out.println("4. The current day is in the " + c.get(Calendar.WEEK_OF_YEAR) + " week of the year");
	}
	
	private static void get20DaysLater() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 20);
		System.out.println("5. 20 days later -> " + format(c, "dd/MM/yyyy EEEE"));
	}
	
	private static void getLifeTime(Date dob) {
		System.out.println("6. Day of Birth: " + format(toCalendar(dob), "dd/MM/yyyy"));
		
		Date now = Calendar.getInstance().getTime();
		long duration = now.getTime() - dob.getTime();
		long daysLife = TimeUnit.MILLISECONDS.toDays(duration);
        System.out.println("   You have lived for " + daysLife + " days");
	}
}
