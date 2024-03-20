package view.localdatetime;

import static utils.DateUtils.optional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Ex03LocalDateTimeDemo {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime sdatetime = LocalDateTime.of(2023, 10, 15, 20, 16, 10);		
		LocalDateTime edatetime = LocalDateTime.parse("28/10/2023 17:40:30", dtf);
		
		System.out.println("sdatetime -> " + sdatetime);
		System.out.println("edatetime -> " + edatetime);
		
		if (edatetime.isBefore(sdatetime)) {
			throw new IllegalArgumentException("DateTime is invalid");
		}
		
		// tg bắt đầu
		LocalDate sdate = sdatetime.toLocalDate();
		LocalTime stime = sdatetime.toLocalTime();
		
		// tg kết thúc
		LocalDate edate = edatetime.toLocalDate();
		LocalTime etime = edatetime.toLocalTime();
		
		// tính hiệu
		Period period = Period.between(sdate, edate);
		Duration duration = Duration.between(stime, etime);	
		
		// mượn 1 ngày khi mà duration có giá trị âm
		if (duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}

		System.out.println("period toString -> " + optional(period.getYears(), "year") 
												+ optional(period.getMonths(), "month")
												+ optional(period.getDays(), "day")
												+ optional(duration.toHoursPart(), "hour")
												+ optional(duration.toMinutesPart(), "minute")
												+ optional(duration.toSecondsPart(), "second"));
	}
}
