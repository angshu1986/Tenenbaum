package chapter3.exercise4;

/**
 * Iterative binary search on sorted array
 * 
 * @author masterfile
 *
 */
public class Question2 {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 7, 15, 21, 22, 36, 78, 95, 106 };
		Question2 q = new Question2();
		System.out.println(q.binSearch(arr, 0, arr.length - 1, 1));
		System.out.println(q.binSearch(arr, 0, arr.length - 1, 20));
		System.out.println(q.binSearch(arr, 0, arr.length - 1, 36));
	}

	private int binSearch(int arr[], int low, int high, int x) {
		while (low <= high) {
			int mid = ((high - low) / 2) + low;
			if (x == arr[mid]) {
				return mid;
			} else if (x > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
