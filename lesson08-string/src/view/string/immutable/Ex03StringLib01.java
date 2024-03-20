package view.string.immutable;

public class Ex03StringLib01 {

	public static void main(String[] args) {
		
		String s = "  welcome   to  class ";
		
		// tính chiều dài của chuối s -> length
		
		// nối chuỗi s1 vào s -> +, concat
		
		// lấy 1 kí tự tại vị trí index(3) trong s
		// -> char letter = s.charAt(3);
		
		// duyệt từng ký tự trong chuỗi
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + " ");
		}

		System.out.println();
		// duyệt từng từ trong chuỗi, các từ cách nhau bởi space
		// thủ công
		s = s.strip().replaceAll("\\s+", " ");
		String word = "";
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (letter == ' ' && word.length() > 0) {
				System.out.println("word: |" + word + "|");
				word = "";
			}
			else {
				word += "" + letter;
				if (i == s.length() - 1)
					System.out.println("word: |" + word + "|");
			}
		}
		
		s = "  welcome   to  class ";
		// dùng hàm có sẵn -> split
		String[] tokens = s.strip().split("\\s+");
		for (String token:tokens) {
			System.out.println("tk -> |" + token + "|");
		}

		s = "welcome   to  class ";
		// tìm vị trí - chỉ số xuất hiện đầu tiên, cuối cùng của kí tự 'c' trong s
		System.out.println("vị trí bắt đầu của 'c' -> " + s.indexOf("c"));
		System.out.println("vị trí cuối cùng của 'c' -> " + s.lastIndexOf("c"));
	}
}
