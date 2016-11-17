package chapter3.exercise3;

/**
 * 8 queens problem <br>
 * <b>Algorithm for the problem</b>
 * <ul>
 * <li>Place the queens col­umn wise, start from the left most column</li>
 * <li>If all queens are placed</li>
 * <ul>
 * <li>return true and print the solu­tion matrix.</li>
 * </ul>
 * <li>Else</li>
 * <ul>
 * <li>Try all the rows in the cur­rent column.</li>
 * <li>Check if queen can be placed here safely if yes mark the cur­rent cell in
 * solu­tion matrix as 1 and try to solve the rest of the prob­lem
 * recursively.</li>
 * <li>If plac­ing the queen in above step leads to the solu­tion return
 * true.</li>
 * <li>If plac­ing the queen in above step does not lead to the solu­tion ,
 * BACKTRACK, mark the cur­rent cell in solu­tion matrix as 0 and return
 * false.</li>
 * </ul>
 * <li>If all the rows are tried and noth­ing worked, return false and print NO
 * SOLUTION.</li>
 * </ul>
 * 
 * @author masterfile
 */
public class Question10 {

	private static final int N = 8;

	private static int sol = 0;
	public static void main(String[] args) {
		long stTime = System.currentTimeMillis();
		new Question10().solve(new int[N][N], 0);
		long endTime = System.currentTimeMillis();
		System.out.printf("Running time %d ms", (endTime - stTime));
	}

	private void solve(int[][] b, int col) {
		if (col == N) {
			// print board and reset
			System.out.printf("Solution number: %d\n", ++sol);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(" " + b[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSafe(i, col, b)) {
				b[i][col] = 1;
				solve(b, col + 1);
			}
			b[i][col] = 0;
		}
	}

	private boolean isSafe(int row, int col, int[][] b) {
		for (int i = 0; i < col; i++) {
			if (b[row][i] == 1) {
				return false;
			}
		}
		// lower right diagonal
		int i = row, j = col;
		while (i < N && j >= 0) {
			if (b[i][j] == 1) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		// upper left diagonal
		i = row;
		j = col;
		if (row > col) {
			while (i >= row - col && j >= 0) {
				if (b[i][j] == 1) {
					return false;
				} else {
					i--;
					j--;
				}
			}
		} else {
			while (i >= 0 && j >= col - row) {
				if (b[i][j] == 1) {
					return false;
				} else {
					i--;
					j--;
				}
			}
		}
		return true;
	}
}
