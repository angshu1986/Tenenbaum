package chapter3.exercise1;

public class Question3 {

	public static void main(String[] args) {
		int arr[] = {3, 78, 12, 5, 8, 6, 1, 40, 56};
		System.out.println(new Question3().avg(arr, arr.length));
	}
	private int max(int []arr, int i) {
		if (i == arr.length) {
			return arr[i - 1];
		} else {
			int temp = max(arr, i + 1);
			if (arr[i] > temp) {
				return arr[i];
			} else {
				return temp;
			}
		}
	}
	//understand by flow diagram
	private int min(int []arr, int i) {
		if (i == arr.length) {
			return arr[i - 1];
		} else {
			int temp = min(arr, i + 1);
			if (arr[i] < temp) {
				return arr[i];
			} else {
				return temp;
			}
		}
	}
	
	private int sum(int []arr, int i) {
		if (i == arr.length) {
			return 0;
		} else {
			return arr[i] + sum(arr, i + 1);
		}
	}
	
	private int prod(int []arr, int i) {
		if (i == arr.length) {
			return 1;
		} else {
			return arr[i] * prod(arr, i + 1);
		}
	}
	
	/**
	 * Avg(N) = (Avg(N-1) * (N-1)+ Nth element) / N
	 * @param arr
	 * @param i
	 * @return
	 */
	private double avg(int []arr, int i) {
		if (i == 0) {
			return 0;
		} else {
			return (avg(arr, i - 1) * (i - 1) + arr[i - 1]) / i;
		}
	}
}
