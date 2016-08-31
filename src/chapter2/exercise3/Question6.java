package chapter2.exercise3;

import java.util.Scanner;

import com.home.ds.adt.IStack;
import com.home.ds.linear.Stack;

/**
 * Infix evaluation
 * Version 1: Solution without parenthesis consideration
 * @author masterfile
 *
 */
public class Question6 {

	private IStack<Double> opnd;
	private IStack<Character> optr;
	public Question6() {
		opnd = new Stack<>();
		optr = new Stack<>();
	}
	public static void main(String[] args) {
		Question6 q = new Question6();
		Scanner s = new Scanner(System.in);
		String input = s.next();
		q.eval(input);
		s.close();
	}
	//TODO: check again, some calc mistake
	private void eval(String input) {
		if (input != null && !input.isEmpty()) {
			char []arr = input.toCharArray();
			String num = "";
			for (char ch : arr) {
				if (isOperator(ch)) {
					double numToDouble = Double.parseDouble(num);
					num = "";
					opnd.push(numToDouble);
					if (optr.isEmpty()) {
						optr.push(ch);
						//opnd.push(numToDouble);
					} else {
						char top = optr.top();
						if (hasPrecedence(ch, top)) {
							optr.push(ch);
							//opnd.push(numToDouble);
						} else {
							//while (!optr.isEmpty()) {
								top = optr.pop();
								double b = opnd.pop();
								double a = opnd.pop();
								opnd.push(operate(a, b, top));	
							//}
							optr.push(ch);
						}
					}
				} else {
					num = num + ch;
				}
			}
			//if format is correct, num will be the last number, and each stack will have one operator and operand
			double last = Double.parseDouble(num);
			opnd.push(last);
			while (!optr.isEmpty()) {
				char op = optr.pop();
				double b = opnd.pop();
				double a = opnd.pop();
				opnd.push(operate(a, b, op));	
			}
			System.out.println("Result: " + opnd.pop());
		}
	}
	
	private double operate(double a, double b, char optr) {
		switch (optr) {
		case '*':
			return a * b;
		case '/':
			return a / b;
		case '+':
			return a + b;
		case '-':
			return a - b;
		default:
			throw new IllegalArgumentException("Only the following four types of operators are allowed  - +, -, *, /");
		}
	}
	
	private boolean isOperator(char ch) {
		return (ch == '+') || (ch == '-') || (ch == '*') || (ch == '/');
	}
	
	private boolean hasSamePrecedence(char optrInStr, char optrTop) {
		return ((optrInStr == '*' || optrInStr == '/') && (optrTop == '*' || optrTop == '/'))
				|| ((optrInStr == '+' || optrInStr == '-') && (optrTop == '+' || optrTop == '-'));
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
