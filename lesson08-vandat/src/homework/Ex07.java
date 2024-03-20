package homework;

public class Ex07 {

	public static void main(String[] args) {
		String s = "aaabaaabbaaaaa";
		String maxSubString = "";
		String minSubString = "";
		
		int maxLength = 1;	// độ dài lớn nhất của dãy con đúng
		int minLength = s.length();	// độ dài nhỏ nhất của dãy con đúng
		int locationMax = 0;// vị trí bắt đầu của dãy con đúng dài nhất trong xâu s
		int locationMin = 0;// vị trí bắt đầu của dãy con đúng ngắn nhất trong xâu s
		
		for (int i = 1; i < s.length(); i++) {
			int length = 1;				// độ dài của 1 dãy con đúng bất ký
			int locationSub = i - 1;	// vị trí bắt đầu của 1 dãy con đúng bất kỳ
			// tìm độ dài của dãy con đúng
			while (i < s.length() && s.charAt(i) == s.charAt(i-1)) {
				length++;
				i++;
			}
			
			if (length > maxLength) {
				maxLength = length;
				locationMax = locationSub;
				maxSubString = s.substring(locationMax, locationMax + maxLength);
			}
			if (length < minLength) {
				minLength = length;
				locationMin = locationSub;
				minSubString = s.substring(locationMin, locationMin + minLength);
			}
		}

		System.out.println("Xâu kí tự: " + s);
		System.out.println("Độ dài lớn nhất của dãy con đúng : " 
							+ maxLength + " " + maxSubString + " [" + locationMax + "]");
		System.out.println("Độ dài lớn nhất của dãy con đúng : " 
							+ minLength + " " + minSubString + " [" + locationMin + "]");
	}
}
