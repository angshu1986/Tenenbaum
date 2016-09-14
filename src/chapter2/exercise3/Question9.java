package chapter2.exercise3;

import com.home.ds.adt.IStack;
import com.home.ds.linear.Stack2;

public class Question9 {

	public static void main(String[] args) {
	}

	//TODO: complete the solution
	private void remove(String infix) {
		IStack<String> opnd = new Stack2<>();
		IStack<String> optr = new Stack2<>();
		char []charArr = infix.toCharArray();
		for (char ch : charArr) {
			if (isOperator(ch)) {
				optr.push(String.valueOf(ch));
			}
			if (')' == ch) {
				
			}
		}
	}
	
	private boolean isOperator(char ch) {
		return (ch == '+') || (ch == '-') || (ch == '*') || (ch == '/');
	}
	
	private boolean hasPrecedence(char optrInStr, char optrTop) {
		if (((optrInStr == '*' || optrInStr == '/') && (optrTop == '*' || optrTop == '/'))
				|| ((optrInStr == '+' || optrInStr == '-') && (optrTop == '+' || optrTop == '-'))) {
			return false;
		} else if ((optrInStr == '+' || optrInStr == '-') && (optrTop == '*' || optrTop == '/')) {
			return false;
		}else {
			return true;
		}
	}
}
