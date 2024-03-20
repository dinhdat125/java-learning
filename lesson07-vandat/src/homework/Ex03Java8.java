package homework;

import static utils.DateUtils.format;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Ex03Java8 {

	public static void main(String[] args) {
		String zoneId = "Asia/Dubai";
		currentTime(zoneId);
		
		getLastDayOfCurrentMonth();
		
		getFirstAndLastDayOfCurrentWeek();
		
		currentDayOfWeekInYear();
		
		get20DaysLater();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dob = LocalDate.parse("12/05/2000", df);
		getLifeTime(dob);
	}
	
	private static void currentTime(String zoneId) {
		LocalDateTime crTime = LocalDateTime.now(ZoneId.of(zoneId));
		System.out.println("1. The current time in " + zoneId + ": " + format(crTime, "dd/MM/yyyy HH:mm:ss"));
	}
	
	private static void getLastDayOfCurrentMonth() {
		LocalDate ldate = LocalDate.now();
		System.out.print("2. The last day of the current month: ");
		System.out.println(ldate.lengthOfMonth() + "/" + ldate.getMonthValue() + "/" + ldate.getYear());
	}
	
	private static void getFirstAndLastDayOfCurrentWeek() {
		LocalDate firstdate = LocalDate.now().with(DayOfWeek.MONDAY);
		System.out.println("3. The first day of the current week: " + format(firstdate, "dd/MM/yyyy"));
		LocalDate lastdate = LocalDate.now().with(DayOfWeek.SUNDAY);
		System.out.println("   The last day of the current week: " + format(lastdate, "dd/MM/yyyy"));
	}
	
	private static void currentDayOfWeekInYear() {
		LocalDate ldate = LocalDate.now();
		System.out.println("4. The current day is in the " + ldate.get(ChronoField.ALIGNED_WEEK_OF_YEAR) + " week of the year");
	}
	
	private static void get20DaysLater() {
		LocalDate ldate = LocalDate.now().plusDays(20);
		System.out.println("5. 20 days later -> " + format(ldate, "dd/MM/yyyy EEEE"));
	}
	
	private static void getLifeTime(LocalDate dob) {
		System.out.println("6. Day of Birth: " + format(dob, "dd/MM/yyyy"));
		
        long daysLife = ChronoUnit.DAYS.between(dob, LocalDate.now());
        System.out.println("   You have lived for " + daysLife + " days");
	}
}
