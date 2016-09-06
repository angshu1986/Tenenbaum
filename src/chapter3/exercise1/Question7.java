package chapter3.exercise1;

public class Question7 {

	public static void main(String[] args) {
		System.out.println(new Question7().ack(1, 3));
	}

	private int ack(int m, int n) {
		if (m == 0) {
			System.out.printf("check m is zero: m = %d, n = %d\n", m, n);
			return n + 1;
		} else if (m != 0 && n == 0) {
			System.out.printf("check m is not zero and n is zero: m = %d, n = %d\n", m, n);
			return ack(m - 1, 1);
		} else {
			System.out.printf("check m is not zero and n is not zero: m = %d, n = %d\n", m, n);
			return ack(m - 1, ack(m, n - 1));
		}
	}
}
