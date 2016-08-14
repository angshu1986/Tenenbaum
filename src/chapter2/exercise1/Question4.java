package chapter2.exercise1;

public class Question4 {

	private static void testStringPattern(String str) {
		if (str != null && !str.isEmpty()) {
			String []arr = str.split("D");
			for (int i = 0; i < arr.length; i++) {
				System.out.println(Question3.testStringPattern(arr[i]));
			}
		}
	}
	public static void main(String[] args) {
		String str = "ABCBADBBAACAABB";
		testStringPattern(str);
	}
}
