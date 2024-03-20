package homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

import static utils.DateUtils.*;

public class Ex01TheUltimateRelationshipCalculator {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/uuuu")
												.withResolverStyle(ResolverStyle.STRICT);
		
		LocalDate startDays = null;
		do {
			System.out.print("Nhập theo mẫu ngày/tháng/năm bắt đầu hẹn hò -> ");
			String input = ip.nextLine();
			try {
				startDays = LocalDate.parse(input, df);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Ngày/tháng/năm nhập vào không hợp lệ !");
			}
		} while (true);
		
		System.out.println("Đã chia tay chưa?\t1. Rồi\t2. Chưa");
		int opption = 0;
		do {
			System.out.print("Nhập lựa chọn (1-2) -> ");
			try {
				opption = Integer.parseInt(ip.nextLine());
				if (opption != 1 && opption != 2)
					throw new NumberFormatException();
				break;
			} catch (NumberFormatException e) {
				System.out.println("Nhập sai lựa chọn !");
			}
		} while (true);
		
		LocalDate endDays = null;
		if (opption == 1) {
			do {
				System.out.print("Nhập theo mẫu ngày/tháng/năm chia tay -> ");
				String input = ip.nextLine();
				try {
					endDays = LocalDate.parse(input, df);
					if (startDays.isAfter(endDays))
						throw new IllegalArgumentException();
					break;
				} catch (DateTimeParseException | IllegalArgumentException e) {
					System.out.println("Ngày/tháng/năm nhập vào không hợp lệ !");
				}
			} while (true);
		}
		else	endDays = LocalDate.now();
		
		System.out.println("Ngày bắt đầu hẹn hò là " + startDays.getDayOfWeek());
		
		Period period = Period.between(startDays, endDays);
		System.out.print("Mối tình đã bắt đầu được ");
		System.out.print(optional(period.getYears(), "năm") 
						+ optional(period.getMonths(), "tháng")
						+ optional(period.getDays(), "ngày"));
		
		if (opption == 2) {		// chưa chia tay thì mới cần đếm đến giờ phút giây
			LocalTime now = LocalTime.now();
			System.out.print(now.getHour() + " giờ " + now.getMinute() + " phút " + now.getSecond() + " giây");
		}
		
		ip.close();
	}
}
