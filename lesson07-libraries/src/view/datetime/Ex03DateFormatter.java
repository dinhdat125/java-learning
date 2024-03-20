package view.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex03DateFormatter {

	public static void main(String[] args) {
		// java7: DateFormat, SimpleDateFormat
		// #format(java.util.Date)
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss EEEE a");
		
		Date date = new Date();
		System.out.println("date -> " + df.format(date));
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, 5);
		Date cDate = c.getTime();	//convert Calendar -> Date
		System.out.println("calendar -> " + df.format(cDate));
	}
}
