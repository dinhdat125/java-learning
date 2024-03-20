package controlling;

import java.util.Random;

public class Ex02SwitchCase {
	public static void main(String[] args) {
		int weekday = new Random().nextInt(2,10);
		
		System.out.println("weekday -> " + weekday);
		
		switch (weekday) {
		case 2,3,4,5,6:
			System.out.println("Ngày trong tuần");
			break;
		case 7,8:
			System.out.println("Ngày cuối tuần");
			break;
		default:
			System.out.println("Không hợp lệ");
		}
		
		String s = switch (weekday) {
			case 2,3,4,5,6 -> "Ngày trong tuần";
			case 7,8 -> "Ngày cuối tuần";
			default -> "Không hợp lệ";
		};
		System.out.println("----" + s);
	}
}
