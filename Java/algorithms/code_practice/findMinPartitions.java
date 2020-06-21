package code_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class findMinPartitions {

	public static boolean isPalin(String s) {
		
		if (s.equals( (new StringBuffer(s).reverse()).toString())) {
			return true;
		} else return false;
	}
	public static void findPartition(String s, int len) {
		int count = 0;
//		if(isPalin(s)) {
//			
//			System.out.println(0); return;
//		} else {
//			count = searchPartitions(s, 0, s.length()-1);
//		}
		
		int mid = (len/2);
		count = searchPartitions(s, 0,len-1);
		System.out.println(count);
		
	}
	public static int searchPartitions(String s, int beg, int end) {
		
		int count = 0;
		
		while (beg <= end) {
			
			if (beg > end) {
				break;
			}
			
			String a = ""+s.charAt(0);
			String res = s.substring(beg+1, end);
			

			if (isPalin(a) && isPalin(res)) {
				count += 1;
			} else {
			
				beg = beg+1;
				int mid = (beg+end+1)/2;
				
				String sub1 = s.substring(beg, mid+1);
				String sub2 = s.substring(mid+1);
				
				if(isPalin(sub1) && isPalin(sub2)) {
					count += 1;
					break;
				} else if (isPalin(sub1)) {
					beg = mid+1;
				} else {
					end = mid-1;
				}
				
			}
			
		}
		return count;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			String s = br.readLine();
			findPartition(s, s.length());
			System.out.println();

		}
		
		
	}

}
