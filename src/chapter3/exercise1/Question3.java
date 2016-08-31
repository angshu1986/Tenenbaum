package chapter3.exercise1;

public class Question3 {

	public static void main(String[] args) {
		int arr[] = {3, 78, 12, 5, 8, 6, 1, 40};
		System.out.println(new Question3().min(arr, 0));
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
}
