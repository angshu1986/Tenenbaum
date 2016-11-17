package chapter3.exercise3;

/**
 * 9 x 9 maze problem. Runner can move horizontally or vertically onto any block
 * containing 0
 * 
 * @author masterfile
 *
 */
public class Question11 {

	private static final int N = 10;
	private static final int maze[][] = { 	{ 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 }, 
											{ 0, 0, 1, 0, 1, 1, 0, 0, 0, 0 },
											{ 1, 0, 0, 0, 1, 1, 0, 0, 1, 0 }, 
											{ 0, 0, 1, 0, 1, 1, 0, 0, 1, 0 }, 
											{ 0, 0, 1, 0, 1, 1, 0, 0, 1, 0 },
											{ 0, 0, 1, 0, 1, 1, 0, 0, 1, 0 }, 
											{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, 
											{ 0, 0, 1, 0, 1, 1, 0, 0, 1, 0 },
											{ 0, 0, 1, 0, 1, 1, 0, 1, 1, 0 }, 
											{ 0, 0, 0, 0, 1, 1, 0, 0, 1, 0 } };

	/*private static final int maze[][] = {	{0, 0, 0, 0, 0},
											{0, 1, 0, 1, 0},
											{0, 0, 0, 1, 0},
											{0, 1, 0, 1, 0},
											{0, 0, 0, 0, 0}};*/
	public static void main(String[] args) {
		int sol[][] = new int[N][N];
		boolean isVisited[][] = new boolean[N][N];
		long stTime = System.currentTimeMillis();
		new Question11().find(sol, isVisited, 0, 0, -1, -1);
		long endTime = System.currentTimeMillis();
		System.out.printf("Running time %d ms", (endTime - stTime));
	}
	private static int count;
	private void find(int sol[][], boolean isVisited[][], int row, int col, int prevRow, int prevCol) {
		isVisited[row][col] = true;
		if (row == N-1 && col == N-1) {
			sol[N-1][N-1] = 1;
			System.out.println("Solution " + ++count);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(sol[i][j] + " ");
				}
				System.out.println();
			}
			sol[row][col] = 0;
			isVisited[row][col] = false;
			return;
		}
		
		if (col != N-1 && (prevCol - 1) != col && maze[row][col+1] != 1 && !isVisited[row][col+1]) {
			sol[row][col] = 1;
			find(sol, isVisited, row, col + 1, row, col);
		}
		//move left, not possible if col = 0
		if (col != 0 &&(prevCol + 1) != col && maze[row][col - 1] != 1 && !isVisited[row][col-1]) {
			sol[row][col] = 1;
			find(sol, isVisited, row, col - 1, row, col);
		}
		//move up, not possible if row = 0
		if (row != 0 && (prevRow + 1) != row && maze[row -1][col] != 1 && !isVisited[row-1][col]) {
			sol[row][col] = 1;
			find(sol, isVisited, row - 1, col, row, col);
		}
		//move down, not possible if row = 9
		if (row != N-1 && (prevRow - 1) != row && maze[row + 1][col] != 1 && !isVisited[row+1][col]) {
			sol[row][col] = 1;
			find(sol, isVisited, row + 1, col, row, col);
		}
		//no solution, backtrack
		sol[row][col] = 0;
		isVisited[row][col] = false;
	}
}
