package chapter3.exercise3;

import java.util.Scanner;

import com.home.ds.util.TestUtils;

/**
 * Find kth smallest element using recursion, a quick select algorithm variant
 * @author masterfile
 *
 */
public class Question9 {

	public static void main(String[] args) {
		Question9 q = new Question9();
		Scanner s = new Scanner(System.in);
		while (true) {
			int l = s.nextInt();
			int k = s.nextInt();

			int a[] = new int[l];
			for (int c = 0; c < l; c++) {
				a[c] = TestUtils.getRandomInteger(1, l * 10);
			}
			int a2[] = new int[l];
			System.arraycopy(a, 0, a2, 0, l);
			q.quickSort(a2, 0, l - 1);
			System.out.println("Original array");
			q.printArray(a);
			System.out.println("Sorted array");
			q.printArray(a2);
			System.out.println(k + " smallest element from sorted array a2 is " + a2[k]);
			System.out.printf("%d smallest element from original array a is %d\n", k, q.quickSelect(a, 0, l - 1, k));
			q.printArray(a);
			if (s.nextInt() == 1) {
				break;
			}
		}
		s.close();
	}

	private void printArray(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i < a.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}

	private int partition(int a[], int st, int end) {
		int pv = a[(st + end) / 2];
		int index = st;
		for (int i = st; i < end; i++) {
			if (a[i] <= pv) {
				swap(a, index, i);
				index++;
			}
		}
		swap(a, index, end);
		return index;
	}

	private void quickSort(int a[], int st, int end) {
		if (st >= end) {
			return;
		}
		int p = partition(a, st, end);
		quickSort(a, st, p - 1);
		quickSort(a, p + 1, end);
	}

	private int quickSelect(int a[], int st, int end, int k) {
		if (st == end) {
			return a[st];
		}
		int p = partition(a, st, end);
		if (k < p) {
			return quickSelect(a, st, p - 1, k);
		} else if (k > p) {
			return quickSelect(a, p + 1, end, k);
		} else {
			return a[p];
		}
	}

	private void swap(int a[], int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
