package view.localdatetime;

import static utils.DateUtils.optional;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex02LocalTimeDemo {

	public static void main(String[] args) {
		LocalTime sTime = LocalTime.of(19, 30, 20);
		
		LocalTime eTime = LocalTime.parse("22:34:44", DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		System.out.println("sTime -> " + sTime);
		System.out.println("eTime -> " + eTime);
		
		// tìm hiệu giữa 2 LocalTime -> Duration
		Duration duration = Duration.between(sTime, eTime);
		System.out.println("duration -> " + duration);
		
		long hours = duration.toHours();
		long minutes = duration.toMinutesPart();
		long seconds = duration.toSecondsPart();
		
		System.out.println("period toString -> " + optional(hours, "hour") 
												+ optional(minutes, "minute")
												+ optional(seconds, "second"));
	}
}
