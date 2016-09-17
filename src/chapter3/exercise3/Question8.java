package chapter3.exercise3;

import java.util.Scanner;

/**
 * max sum sub array max (maxSumLeft,maxSumRight,maxSumCrossing)
 * 
 * @author masterfile
 *
 */
public class Question8 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int arr[] = new int[l];
		for (int i = 0; i < l; i++) {
			arr[i] = s.nextInt();
		}
		System.out.print("[ ");
		for (int i = 0; i < l;) {
			System.out.print(arr[i]);
			if (++i < l) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
		Question8 q = new Question8();
		System.out.println(q.maxSum(arr, 0, arr.length - 1));
		System.out.println(q.maxSum(arr));
		s.close();
	}
	
	/**
	 * Iterative Kadane's algorithm
	 * @param arr
	 * @return
	 */
	private int maxSum(int[] arr) {
		int maxSum = 0;
		int tmpSum = 0;
		int maxNeg = Integer.MIN_VALUE;
		for (int a : arr) {
			tmpSum += a;
			if (tmpSum < 0) {
				tmpSum = 0;
			}
			if (tmpSum > maxSum) {
				maxSum = tmpSum;
			}
			if (a < 0) {
				if (maxNeg < a) {
					maxNeg = a;
				}
			}
		}
		return maxSum != 0 ? maxSum : maxNeg;
	}

	private int maxCrossingSum(int arr[], int st, int mid, int end) {
		System.out.printf("Start = %d, mid = %d, end = %d\n", st, mid, end);
		int lSum = Integer.MIN_VALUE;
		int rSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= st; i--) {
			sum += arr[i];
			if (sum > lSum) {
				lSum = sum;
			}
		}
		sum = 0;
		for (int i = mid + 1; i <= end; i++) {
			sum += arr[i];
			if (sum > rSum) {
				rSum = sum;
			}
		}
		return lSum + rSum;
	}

	private int maxSum(int[] arr, int st, int end) {
		if (st == end) {
			return arr[st];
		} else {
			int mid = (st + end) / 2;
			int lSum = maxSum(arr, st, mid);
			int rSum = maxSum(arr, mid + 1, end);
			int cSum = maxCrossingSum(arr, st, mid, end);
			System.out.printf("Left half = %d, right half = %d, Crossing sum = %d\n", lSum, rSum, cSum);
			return max(lSum, rSum, cSum);
		}
	}

	private int max(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}
}
