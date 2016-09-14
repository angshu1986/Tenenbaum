package chapter2.exercise3;

import com.home.ds.adt.IStack;
import com.home.ds.linear.Stack2;

public class Question5 {

	public static void main(String[] args) {
		Question5 q = new Question5();
		System.out.println(q.infixFromPostfix("AB+C-"));
		System.out.println(q.infixFromPostfix("ABC+-"));
		System.out.println(q.infixFromPostfix("AB-C+DEF-+$"));
		System.out.println(q.infixFromPostfix("ABCDE-+$*EF*-"));
	}

	//TODO: check validations
	private String infixFromPostfix(String post) {
		IStack<String> st = new Stack2<>();
		String inFix = "";
		char[] arr = post.toCharArray();
		for (char a : arr) {
			if (isOperator(a)) {
				String top1 = st.pop();
				String top2 = st.pop();
				inFix = "(" + top2 + a + top1 + ")";
				st.push(inFix);
				inFix = "";
			} else {
				st.push(String.valueOf(a));
			}
		}
		return st.pop();
	}

	private boolean isOperator(char ch) {
		return (ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || (ch == '$');
	}
}
