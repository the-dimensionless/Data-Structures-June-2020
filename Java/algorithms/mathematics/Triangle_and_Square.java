package mathematics;

/**
 * Check out this link for reference.
	https://www.geeksforgeeks.org/maximum-number-2x2-squares-can-fit-inside-right-isosceles-triangle/
	
	Given a positive integer B denoting the base of a right angled isosceles triangle. 
	Find the maximum number of squares of size 2×2 units that can fit in it.
	
	Input:
	First line of input contains an integer T denoting number of test cases. For each test case, there exists one line containing integer B ie-base of right angled isosceles triangle.
	Output:
	For each test case, print the maximum number of squares that can be fit into the triangle.
	
	Constraints:
	1<= T <=100
	1<= B <= 1000
	
	Example:
	Input:
	2
	8
	2
	Output:
	6
	0
 */

import java.util.Scanner;

public class Triangle_and_Square {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int testCases = kb.nextInt();
		for (int i = 0; i < testCases; i++) {
			int base = kb.nextInt();
			int answer = 0;
			while (base > 2) {
				answer += (base - 2) / 2;
				base = base - 2;
			}
			System.out.println(answer);
		}

		kb.close();
	}

}
