package view;

public class Ex03 {

	public static void main(String[] args) {
		String input = " Welcome  to JAVA21  class";
		String output = revert(input);
		System.out.println("input :" + input + "\noutput:" + output);
	}
	
	private static String revert(String s) {
		String result = "";
		String[] words = s.strip().split("\\s+");
		for (String word:words) {
			for (int i = word.length() - 1; i >= 0 ; i--) {
				result += word.charAt(i);
			}
			result += " ";
		}
		return result.strip();
	}
}
