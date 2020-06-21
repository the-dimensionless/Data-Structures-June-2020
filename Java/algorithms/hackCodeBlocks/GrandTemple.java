package hackCodeBlocks;

import java.util.Arrays;
import java.util.Scanner;

public class GrandTemple {

	public static void findMaxArea(long x[], long y[], int n) {
		long area = 0l;
		long max_y = 0;
		Arrays.sort(x); Arrays.sort(y);
		
		for(int i=0; i<n-1;i++) {
			if ( Math.abs(y[i] - y[i+1]) > max_y) {
				max_y = Math.abs(y[i] - y[i+1]);
			}
		}
		
		for(int i=0;i<n-1;i++) {
			if ((Math.abs(x[i]-x[i+1])-1)*(max_y-1) > area) {
				area = (Math.abs(x[i]-x[i+1])-1)*(max_y-1);
			}
		}
		
		System.out.println(area);
		
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		long x[] = new long[n];
		long y[] = new long[n];
		
		for(int i=0;i<n;i++) {
			x[i] = kb.nextLong();
			y[i] = kb.nextLong();
		}
		findMaxArea(x, y, n);

	}

}
