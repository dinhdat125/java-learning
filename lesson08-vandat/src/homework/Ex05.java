package homework;

public class Ex05 {

	public static void main(String[] args) {
		String s1 = "FABCDEDEABCE";
		String s2 = "ABCEDCBBCK";
		
		System.out.println("S1:" + s1 + "\nS2:" + s2 + "\n=> " + commonSubstring(s1, s2));
	}
	
	private static String commonSubstring(String s1, String s2) {
		String result = "";
		int iSub;				// biến để đếm vị trí có ký tự thuộc chuỗi con trong chuỗi s1
		int jSub;				// biến để đếm vị trí có ký tự thuộc chuỗi con trong chuỗi s2
		int lengthSub;			// biến đếm độ dài chuỗi con
		int maxLengthSub = 0;	// biến đếm độ dài của chuỗi con dài nhất
		
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				iSub = i;
				jSub = j;
				lengthSub = 0;
//				if (s1.charAt(i) == s2.charAt(j)) {
//					do {
//						iSub++;
//						jSub++;
//						lengthSub++;
//					} while (iSub < s1.length() && jSub < s2.length() && s1.charAt(iSub) == s2.charAt(jSub));
//				}
				// nếu có ký tự chung thì bắt đầu đếm để so sánh các ký tự liền sau
				while (iSub < s1.length() && jSub < s2.length() && s1.charAt(iSub) == s2.charAt(jSub)) {
					iSub++;
					jSub++;
					lengthSub++;
				}
				if (lengthSub > maxLengthSub) {
					result = s1.substring(i, iSub);
					maxLengthSub = lengthSub;
				}
			}
		}
		
		return result;
	}
}
