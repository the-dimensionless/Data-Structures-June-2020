package misc;

import java.util.Scanner;

public class RubyNumbersInRange {
	
	static int nCr(int n, int r) 
	{ 
	    return fact(n) / (fact(r) * 
	                  fact(n - r)); 
	} 
	
	static int fact(int n) 
	{ 
	    int res = 1; 
	    for (int i = 2; i <= n; i++) 
	        res = res * i; 
	    return res; 
	} 
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		int z = n/2;
		int ans = z * nCr(k, 1) + ( (n-z) * nCr(k-1,1));
		System.out.println(ans);
		kb.close();
	}

}
