package chapter3.exercise2;

public class Question1 {
	public static void main(String[] args) {
		Question1 q = new Question1();
		System.out.println(q.func(6));
		System.out.println(q.func2(7));
		System.out.println(q.func3(8));
		System.out.println(q.func4(9));
	}

	private int func(int n) {
		if (n == 0) {
			return 0;
		} else {
			return (n + func(n - 1));
		}
	}
	
	private int func2(int n) {
		return n * (n+1) / 2;
	}
	
	private int func3(int n) {
		int s = 0;
		while (n > 0) {
			s += n--;
		}
		return s;
	}
	
	private int func4(int n) {
		int s = 0;
		for (int i = 1; i <= n;) {
			s += i++;
		}
		return s;
	}
}
