package chapter2.exercise1;

import com.home.ds.adt.IStack;
import com.home.ds.linear.Stack2;

public class Question3 {

	public static boolean testStringPattern(String str) {
		if (str != null && !str.isEmpty()) {
			char[] charArr = str.toCharArray();
			IStack<Character> s = new Stack2<>();
			int i = 0;
			while (charArr[i] != 'C') {
				char ch = charArr[i++];
				s.push(ch);
			}
			for (int j = i + 1; j < charArr.length; j++) {
				char ch = charArr[j];
				if (ch == s.pop()) {
					continue;
				} else {
					return false;
				}
			}
			return true;
		}
		throw new IllegalArgumentException("Null or empty string" + str);
	}

	public static void main(String[] args) {
		String str = "BABAABABCBABAABAA";
		System.out.println(testStringPattern(str));
	}
}
