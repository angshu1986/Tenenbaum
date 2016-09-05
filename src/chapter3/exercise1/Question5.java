package chapter3.exercise1;

public class Question5 {
	
	public static void main(String[] args) {
		int arr[] = {1,3,7,15,21,22,36,78,95,106};
		Question5 q = new Question5();
		System.out.println(q.binSearch(arr, 0, arr.length -1, 1));
		System.out.println(q.binSearch(arr, 0, arr.length -1, 20));
		System.out.println(q.binSearch(arr, 0, arr.length -1, 36));
	}

	private int binSearch(int arr[], int low, int high, int x) {
		if (low > high) {
			return -1;
		}
		int mid = ((high - low) / 2) + low;
		if (x == arr[mid]) {
			return mid;
		} else if (x > arr[mid]) {
			return binSearch(arr, mid + 1, high, x);
		} else {
			return binSearch(arr, low, mid - 1, x);
		}
	}
}
