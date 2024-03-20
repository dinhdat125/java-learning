package view.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Ex01BasicDemo {

	public static void main(String[] args) {
		// java7: java.util.Date, java.util.Calendar
		/*
		 Date: thường đc dùng để lưu trữ, không hỗ trợ quá nhiều hàm xử lý
		 Calendar: cho phép lưu trữ, hỗ trợ các hàm xử lý
		 */
		// demo with java.util.Date
		Date date = new Date();
		System.out.println("date -> " + date);	//Sat Oct 21 19:43:31 GMT+07:00 2023(os time)
		
		Date configuredDate = new Date(765432100);
		System.out.println("configuredDate -> " + configuredDate);
		
		System.out.println("TimeZone default: " + TimeZone.getDefault());
		//printAvailableTimeZones();
		
		// demo with java.util.Calendar(code with style of singleton pattern)
		Calendar calendar = Calendar.getInstance();
		System.out.println("calendar -> " + calendar);
		
		TimeZone tzMexico = TimeZone.getTimeZone("Mexico/General");
		Calendar cMexico = Calendar.getInstance(tzMexico);
		System.out.println("calendar Mexico -> " + cMexico);
		
		// calendar : fields[]
		cMexico.set(Calendar.YEAR, 2020);	//fields[1] = 2020
		int year = cMexico.get(Calendar.YEAR);
		int hour = cMexico.get(Calendar.HOUR_OF_DAY);
		int minute = cMexico.get(Calendar.MINUTE);
		int second = cMexico.get(Calendar.SECOND);
		System.out.println("Mexico year -> " + year);
		System.out.println("Mexico time -> " + (hour + ":" + minute + ":" + second));
		
	}
	
	/*
	private static void printAvailableTimeZones() {
		String[] tzIds = TimeZone.getAvailableIDs();
		for (String tzId:tzIds)
			System.out.println("tzId -> " + tzId);
	}
	*/
}
