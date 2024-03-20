package view.localdatetime;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ex04TimeZoneDemo {

	public static void main(String[] args) {
		// TimeZone = ZoneId
		// GMT+7, UTC+7
		// ICT, HST, Europe/Berlin
		
		ZoneId zoneId = ZoneId.of("Europe/Berlin");
		LocalDateTime ldatetime = LocalDateTime.now(zoneId);
		
		System.out.println("ldatetime -> " + ldatetime);
	}
}
