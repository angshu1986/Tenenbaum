package chapter3.exercise2;

/**
 * Generalized fibonacci sequence where f0 != 1 and f1 != 1
 * Run the function with initial values as 1 to get the fibonacci series
 * @author masterfile
 *
 */
public class Question4 {
	public static void main(String[] args) {
		System.out.println(new Question4().gfib(5, 3, 6));
		System.out.println(new Question4().gfibItr(5, 3, 6));
	}

	private int gfib(int f0, int f1, int n) {
		if (n == 0) {
			return f0;
		} else if (n == 1) {
			return f1;
		} else {
			return gfib(f0, f1, n - 1) + gfib(f0, f1, n - 2);
		}
	}

	private int gfibItr(int f0, int f1, int n) {
		int x = f0;
		int y = f1;
		int s = 0;
		if (n == 0) {
			return f0;
		}
		if (n == 1) {
			return f1;
		}
		for (int i = 2; i <= n; i++) {
			s = x + y;
			x = y;
			y = s;
		}
		return s;
	}
}
