package chapter3.exercise2;

/**
 * Calculate combination using pascal's triangle
 *n=0											1
 *n=1										1		1
 *n=2									1		2		1
 *n=3								1		3		3		1
 *n=4							1		4		6		4		1
 *n=5						1		5		10		10		5		1
 *n=6					1		6		15		20		15		6		1
 *n=7				1		7		21		35		35		21		7		1
 *n=8			1		8		28		56		70		56		28		8		1
 *n=9		1		9		36		84		126		126		84		36		9		1
 *n=10	1		10		45		120		210		252		210		120		45		10		1
 * @author masterfile
 *
 */
public class Question3 {

	public static void main(String[] args) {
		System.out.println(new Question3().comb(10, 5));
	}

	private int comb(int n, int k) {
		if (k == 0) {
			return 1;
		} else if (k == 1) {
			return n;
		} else if (n == 1) {
			return 0;
		} else {
			return comb(n - 1, k) + comb(n - 1, k - 1);
		}
	}
}
