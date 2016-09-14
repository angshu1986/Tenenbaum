package chapter3.exercise3;

/**
 * Partition function
 * 
 * @author masterfile
 *
 */
public class Question7 {

	public static void main(String[] args) {
		System.out.println(count(6, 5));
	}

	private static int count(int n, int k) {
		if (n <= 1) {
			return 1;
		}
		int sum = 0;
		for (int i = 1; i <= k; i++) {
			sum += count(n - i, i);
		}
		return sum;
	}
}
