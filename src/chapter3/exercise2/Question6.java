package chapter3.exercise2;

import com.home.ds.util.TestUtils;

/**
 * Find determinant of a matrix
 * for m x n matrix A
 * det(A) = a[1, 1] if m=n=1
 * else
 * for any row or column,
 * Sum(-1^(i+j) * A[i, j] * det(minor(A[i, j])))
 * sample
 * |2	9	4	1|
 * |3	6	0  -1|
 * |-5  8	1	5|
 * |8	4	2	3|
 * @author masterfile
 *
 */
public class Question6 {

	public static void main(String[] args) {
		Question6 q = new Question6();
		int order = 4;
		int[][] a = new int[order][order];
		for (int i = 0; i < order; i++) {
			for (int j = 0; j < order; j++) {
				a[i][j] = TestUtils.getRandomInteger(1, 10);
			}
		}
		System.out.println("**********Printing matrix**********");
		for (int i = 0; i < order; i++) {
			System.out.print("|	");
			for (int j = 0; j < order; j++) {
				System.out.print(a[i][j] + "	");
			}
			System.out.print("|\n");
		}
		System.out.println(q.det(a, order));
	}

	private int det(int[][] a, int order) {
		int sum = 0;
		int i = 0;		
		if (order == 1) {
			return a[0][0];
		}
		for (int x = 0; x < order; x++) {
			int [][]minor = minor(a, i, x, order);
			sum += (isEven(i, x) ? 1 : -1) * a[i][x] * det(minor, order - 1);
		}
		return sum;
	}
	
	private boolean isEven(int x, int y) {
		return ((x + y) % 2) == 0;
	}

	private int[][] minor(int[][] arr, int row, int col, int order) {
		int newArr[][] = new int[order - 1][order - 1];
		int m = 0;
		for (int i = 0; i < order; i++) {
			if (i == row) {
				continue;
			}
			int n = 0;
			for (int j = 0; j < order; j++) {
				if (j == col) {
					continue;
				}
				newArr[m][n] = arr[i][j];
				n++;
			}
			m++;
		}
		System.out.printf("Minor for %d row %d column value %d order %d\n", row, col, arr[row][col], order);
		for (int x = 0; x < order - 1; x++) {
			System.out.print("|	");
			for (int y = 0; y< order - 1; y++) {
				System.out.print(newArr[x][y] + "	");
			}
			System.out.print("|\n");
		}
		return newArr;
	}

}
