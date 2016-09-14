package chapter3.exercise2;

/**
 * Classic merge sort, try using indexes only instead of creating new arrays
 * while writing same program in sorting chapter. Use helper array
 * 
 * @author masterfile
 *
 */
public class Question7 {

	public static void main(String[] args) {
		Question7 q = new Question7();
		int arr[] = { 45, 20, 84, 56, 84, 10, 65, 47, 11, 9, 89, 102, 97, 31 };
		q.sort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	private void sort(int[] arr, int st, int end) {
		if (st >= end) {
			return;
		}
		int k = (end - st) / 2 + st;
		int arr1[] = new int[k + 1];
		int arr2[] = new int[end - k];
		System.arraycopy(arr, st, arr1, 0, arr1.length);
		System.arraycopy(arr, k + 1, arr2, 0, arr2.length);
		sort(arr1, 0, arr1.length - 1);
		sort(arr2, 0, arr2.length - 1);
		System.out.println("Printing array 1");
		System.out.print("[	");
		for (int i : arr1) {
			System.out.print(i+"	");
		}
		System.out.print("]");
		System.out.println();
		System.out.println("Printing array 2");
		System.out.print("[	");
		for (int i : arr2) {
			System.out.print(i+"	");
		}
		System.out.print("]");
		System.out.println();
		merge(arr1, arr2, arr);
	}

	private void merge(int arr1[], int arr2[], int arr[]) {
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] > arr2[j]) {
				arr[k++] = arr2[j++];
			} else {
				arr[k++] = arr1[i++];
			}
		}
		while (i < arr1.length) {
			arr[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			arr[k++] = arr2[j++];
		}
	}
}
