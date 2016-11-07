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

	public static void main(String[] args) {

	}

}
