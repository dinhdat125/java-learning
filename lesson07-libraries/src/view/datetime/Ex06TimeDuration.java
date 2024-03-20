package view.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static utils.DateUtils.*;

public class Ex06TimeDuration {

	public static void main(String[] args) {
		Date start = toDate("15/10/2023 15:00:00", "dd/MM/yyyy HH:mm:ss", false);
		Date end = Calendar.getInstance().getTime();
		
		if (start.after(end))
			throw new IllegalArgumentException("Date range is invalid");
		
		long startTime = start.getTime();
		long endTime = end.getTime();
		long duration = endTime - startTime;	//ms
		
		long days = TimeUnit.MILLISECONDS.toDays(duration);	// convert from ms to days
		duration -= TimeUnit.DAYS.toMillis(days);
		long hours = TimeUnit.MILLISECONDS.toHours(duration);
		duration -= TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
		duration -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration);
		
		System.out.println(days + " day " + hours + " hour " + minutes + " minute " + seconds + " second");
		
		/*
		 Hạn chế của Date Time trước java 1.8
		 
		  + Date, Calendar luôn lưu trữ dMy Hms 
		  	-> k hỗ trợ riêng lẻ
		  	-> khó khăn khi lưu trữ cũng như chuyển đổi qua về với date(dMy) time(Hms) trong datebase
		  + Ít hàm hỗ trợ tìm hiêu giữa 2 mốc tg
		  
		 */
	}
}
