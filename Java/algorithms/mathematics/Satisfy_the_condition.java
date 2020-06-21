package mathematics;

/**
 * Given an integer X. Your task is to find out how many 
 * positive integers N ( 1 <= N <= X)  satisfy the following condition:-
	n*an ≡ b (mod p)
	
	Input:
	First line of input contains T denoting the number of test cases. 
	For each test case, the first line contains 4 spaces separated integers 
	denoting values of  a , b , p (prime no.)  and X respectively.
	
	Output:
	For each test case, print the number of possible answers  N.
	
	Constraints:
	1 <= T <= 100
	2 <= p <= 106
	1 <= a,b< p
	1 <= X <= 1012
	
	Example:
	Input:
	2
	17 17 19 12
	2 2 3 19
	Output:
	1
	7
	
	For Full code refer : https://ide.geeksforgeeks.org/lQqbb3ypCD
 */
import java.util.Scanner;

public class Satisfy_the_condition {

	static boolean isValid (int a, int b, int p, int n) {
		
		if ( (n * (Math.pow(a, n))) == (b % p)) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int testCases = kb.nextInt();
		for (int i = 0; i < testCases; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int p = kb.nextInt();
			int x = kb.nextInt();
			int sol = 0;
			
			for (int j=1 ; j<=x ; j++) {
				if (isValid(a,b,p,j)) {
					sol += 1;
				}
			}
			
			System.out.println(sol);
		}
		kb.close();

	}

}
