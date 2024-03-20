package view.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex04DateConverter {

	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		
		// input
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		String text = "34/10/2023";
		
		// converter
		// calendar -> date
		Date convertedDate = c.getTime();
		System.out.println("calendar -> date: " + convertedDate);
		
		// calendar -> date -> string
		String convertedText = df.format(convertedDate);
		System.out.println("calendar -> date -> string: " + convertedText);
		
		// date -> calendar
		Calendar convertedCalendar = Calendar.getInstance();
		convertedCalendar.setTime(date);
		System.out.println("date -> calendar: " + convertedCalendar);
		
		// string -> date
		try {
			convertedDate = df.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("string -> date: " + convertedDate);
		
	}
}
