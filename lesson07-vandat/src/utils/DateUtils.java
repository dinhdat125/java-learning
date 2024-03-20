package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateUtils {

	public DateUtils() {
	}
	
	public static String optional(long value, String unit) {
		if (value == 0)
			return "";
		return value + " " + unit + " ";
	}
	
	public static String format(LocalDate localDate, String pattern) {
		Objects.requireNonNull(localDate, "c should not be null");
		Objects.requireNonNull(pattern, "patern is invalid");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		return dtf.format(localDate);
	}
	
	public static String format(LocalDateTime localDateTime, String pattern) {
		Objects.requireNonNull(localDateTime, "c should not be null");
		Objects.requireNonNull(pattern, "patern is invalid");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		return dtf.format(localDateTime);
	}
	
	public static Date toDate(Calendar c) {
		Objects.requireNonNull(c, "c should not be null");
		return c.getTime();
	}
	
	public static Date toDate(String text, String pattern, boolean isLenient) {
		Objects.requireNonNull(text, "c should not be null");
		Objects.requireNonNull(pattern, "patern is invalid");
		DateFormat df = new SimpleDateFormat(pattern);
		df.setLenient(isLenient);
		Date date = null;
		try {
			date = df.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String format(Calendar c, String pattern) {
		Objects.requireNonNull(c, "c should not be null");
		Objects.requireNonNull(pattern, "patern is invalid");
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(toDate(c));
	}
	
	public static Calendar toCalendar(Date date) {
		Objects.requireNonNull(date, "date should not be null");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
	
	/*
	public static String format(Date date, String pattern) {
		Objects.requireNonNull(date, "c should not be null");
		Objects.requireNonNull(pattern, "patern is invalid");
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	
	public static LocalDate toLocalDate(String text, String pattern) {
		Objects.requireNonNull(text, "c should not be null");
		Objects.requireNonNull(pattern, "patern is invalid");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate localDate = null;
		try {
			localDate = LocalDate.parse(text, df);
		} catch (DateTimeParseException e) {
			System.out.println("Ngày/tháng/năm nhập vào không hợp lệ !");
		}
		return localDate;
	}
	
	*/
	
}
