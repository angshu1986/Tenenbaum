package chapter3.exercise2;

public class Question4 {
	public static void main(String[] args) {
		System.out.println(new Question4().gfib(5, 3, 2));
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
}
