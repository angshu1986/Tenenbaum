package chapter3.exercise1;

public class Question1 {
	public static void main(String[] args) {
		System.out.println(new Question1().mul(12, 7));
	}
	private double mul(double a, double b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Non negative numbers not allowed");
		}
		double m = 0;
		while (b-- != 0) {
			m+=a;
		}
		return m;
	}
}
