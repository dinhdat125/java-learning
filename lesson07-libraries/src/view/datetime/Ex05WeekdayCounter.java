package view.datetime;

import java.util.Calendar;

import static utils.DateUtils.*;

public class Ex05WeekdayCounter {

	private static final String DEFAULT_PATTERN = "dd/MM/yyyy";
	
	public static void main(String[] args) {
		//đếm xem tháng bất kì có bao nhiêu ngày chủ nhật
		Calendar now = Calendar.getInstance();
		System.out.println("Hiện tại: " + format(now, DEFAULT_PATTERN));
		
		//ngày đầu tháng
		Calendar start = clone(now);
		start.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println("Đầu tháng: " + format(start, DEFAULT_PATTERN));
		
		//ngày cuối tháng
		Calendar end = clone(now);
		end.set(Calendar.DAY_OF_MONTH, now.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("Cuối tháng: " + format(end, DEFAULT_PATTERN));
		
		//đếm số ngày chủ nhật
		Calendar startOfNewMonth = clone(end);
		startOfNewMonth.add(Calendar.DAY_OF_MONTH, 1);
		
		for (Calendar cal = start; cal.before(startOfNewMonth);) {
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				System.out.println(format(cal, DEFAULT_PATTERN));
				cal.add(Calendar.DAY_OF_MONTH, 7);
			}
			else cal.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
	
	public static Calendar clone(Calendar c) {
		Calendar clone = Calendar.getInstance();
		clone.setTime(c.getTime());
		return clone;
	}
}
