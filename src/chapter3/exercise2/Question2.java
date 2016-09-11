package chapter3.exercise2;

public class Question2 {
	public static void main(String[] args) {
		Question2 q = new Question2();
		System.out.println(q.gcd(14, 21));
	}
	
	private int gcd(int x, int y) {
		if (y <= x && x % y == 0) {
			return y;
		} else if (x < y) {
			return gcd(y, x);
		} else {
			return gcd(y, x % y);
		}
	}
}
