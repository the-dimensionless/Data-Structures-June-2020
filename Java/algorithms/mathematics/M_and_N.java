package mathematics;

/**
 * Question : Given two positive integers M and N, after adding M and N if number of digits in M+N
   			  and N are same return N otherwise return M+N.
	Input:
	First line of input contains T denoting number of test cases. For each test case there will be 
	two space separated positive integers M and N.
	
	Output:
	If number of digits in M+N is same as N print N otherwise print M+N.
	Constraints:
	1 <= T <= 100
	1 <= M <= 109
	1 <= N <=109
	
	Example:
	
	Input:
	2
	44 22
	99 12
	
	Output:
	22
	111
 */

import java.util.Scanner;

public class M_and_N {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int testCases = kb.nextInt();
		for (int i = 0; i < testCases; i++) {
			int M = kb.nextInt();
			int N = kb.nextInt();
			
			int noOfDigits = (int) Math.log10((M+N)) + 1;
			int noInN = (int) Math.log10(N) + 1;
			
			if (noInN == noOfDigits) {
				System.out.println(N);
			} else {
				System.out.println(M+N);
			}
		}
		kb.close();

	}

}
