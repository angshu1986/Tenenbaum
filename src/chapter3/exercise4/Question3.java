package chapter3.exercise4;

/**
 * Fibonacci series using iteration
 * 
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 * @author masterfile
 *
 */
public class Question3 {

	public static void main(String[] args) {
		System.out.println(new Question3().fib(8));
	}

	private int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int x = 0;
		int y = 1;
		int s = 0;
		for (int i = 2; i <=n; i++) {
			s = x + y;
			x = y;
			y = s;
		}
		return s;
	}
}
