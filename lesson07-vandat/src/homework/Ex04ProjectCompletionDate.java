package homework;

import static utils.DateUtils.format;

import java.util.Calendar;

public class Ex04ProjectCompletionDate {

	public static void main(String[] args) {
		Calendar projectDay = setDate(7, 6, 2022);
		int days = 110;		// thời gian yêu cầu của dự án
		
		int count = 0;		// đếm ngày thực hiện dự án
		do {
			projectDay.add(Calendar.DAY_OF_MONTH, 1);	// bắt đầu tính 1 ngày của dự án
			if (!isDayOff(projectDay)) {				// nếu k phải ngày nghỉ thì sẽ tăng 1
				count ++;
			}
		} while (count < days);
		System.out.println("Deadline -> " + format(projectDay, "dd/MM/yyyy"));
	}
	
	private static boolean isDayOff(Calendar checkDate) {
		if (checkDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY 
				|| checkDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| isHoliday(checkDate))
			return true;	// nếu ngày cần kiểm tra là thứ 7 hoặc CN hoặc ngày lễ thì được tính là ngày nghỉ
		
		return false;
	}
	
	private static boolean isHoliday(Calendar checkHoliday) {
		for (Calendar holiday : getHolidays()) {
			if (checkHoliday.get(Calendar.DAY_OF_MONTH) == holiday.get(Calendar.DAY_OF_MONTH)
					&& checkHoliday.get(Calendar.MONTH) == holiday.get(Calendar.MONTH))
					return true;	// nếu ngày cần kiểm tra bằng 1 trong các ngày lễ thì return true
		}
		
		return false;
	}
	
	private static Calendar setDate(int day, int month, int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, day);
		return c;
	}
	
	private static Calendar[] getHolidays() {
		Calendar[] holidays = new Calendar[] {
				setDate(1, 1, 0),
				setDate(30, 4, 0),
				setDate(1, 5, 0),
				setDate(2, 9, 0)
				// ngày lễ dương lịch, còn lễ âm lịch thì chưa xác định được
		};
		return holidays;
	}
}
