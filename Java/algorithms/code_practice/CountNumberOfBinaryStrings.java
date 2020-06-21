package code_practice;

import java.util.Scanner;

public class CountNumberOfBinaryStrings {

	static int count = 0;
	static int fib(int n) { 
		double phi = (1 + Math.sqrt(5)) / 2; 
		return (int) Math.round(Math.pow(phi, n+2)  
		                        / Math.sqrt(5)); 
		} 
	public static long findDP(int lt) {
		
		long a[] = new long[lt];
		long b[] = new long[lt];
		a[0] = 1;
		b[0] = 1;
		
		for(int i=1;i<lt;i++) {
			a[i] = a[i-1]+b[i-1];
			b[i] = a[i-1];
		}
		return a[lt-1]+b[lt-1];
	}
	public static void find(String s,int current, int limit) {
		if(s.length() == limit) {
			System.out.println(s);
			count++; 
			return;
		} else if (s.charAt(s.length()-1) == '0') {
			find(s+'0', current+1, limit);
			find(s+'1', current+1, limit);
		} else if(s.charAt(s.length()-1) == '1') {
			find(s+'0', current+1, limit);
		}
	}
	public static int countStrings(int a) {
		find("0",1,a);
		find("1",1,a);
		return count;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int test = kb.nextInt();
		long a[]= new long[test];
		for(int i=0;i<test;i++) {
			a[i] = kb.nextLong();
		}
		
		for(int i=0;i<test;i++) {
//			System.out.println(countStrings(a[i]));
			System.out.println(findDP((int) a[i]));
//			System.out.println(fib(a[i]));
			count = 0;
		}

	}

	
}
