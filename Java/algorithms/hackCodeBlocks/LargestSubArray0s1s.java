package hackCodeBlocks;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestSubArray0s1s {

	public static void findLargestSubArray(Integer arr[], int len) {
		String s = "";
		for (int i = 0; i < len; i++) {
			s += arr[i].toString();
		}
		int countZeros = 0; int lower = 0; int upper = 0;
		int countOnes = 0; int max = 0;
		for (int i = 0; i < len; i++) {
			countZeros = 0;
			countOnes = 0;
			String sub = ""+s.charAt(i);

			if (s.charAt(i) == '0') {
				countZeros++;
			} else if (s.charAt(i) == '1') {
				countOnes++;
			}
			for (int j = i + 1; j < len; j++) {
				sub += s.charAt(j);
				if (s.charAt(j) == '0') {
					countZeros++;
				} else if (s.charAt(j) == '1') {
					countOnes++;
				}
				
				if(countZeros == countOnes && max < (j-i+1)) {
					max = j-i+1;
					lower = i; upper = j;
				}
			}
		}
		if(max == 0) {
			System.out.println("None"); return;
		}
		System.out.println(lower+" "+upper);
//		System.out.println("max is "+max+ " lower bound "+lower+" upper bound "+upper);
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		ArrayList<Integer[]> al = new ArrayList<Integer[]>();
		for (int i = 0; i < t; i++) {
			int n = kb.nextInt();
			Integer arr[] = new Integer[n];
			for (int j = 0; j < n; j++) {
				arr[j] = kb.nextInt();
			}
			al.add(arr);
		}

		for (Integer[] i : al) {
			findLargestSubArray(i, i.length);
		}

	}

}
