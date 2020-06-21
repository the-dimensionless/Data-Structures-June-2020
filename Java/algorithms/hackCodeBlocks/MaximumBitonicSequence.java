package hackCodeBlocks;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumBitonicSequence {

	public static void findMaxBS(Integer[] arr, int len) {
		Integer longestInc[] = new Integer[len];
		Integer longestDec[] = new Integer[len];
		int longestBitonicSeq = 0;

		for (int i = 0; i < len; i++) {
			longestDec[i] = 1;
			longestInc[i] = 1;
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if ((arr[i] > arr[j]) && (longestInc[i] < longestInc[j] + 1)) {
					longestInc[i] = longestInc[j] + 1;
				}
			}
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = len - 1; j > i; j--) {
				if ((arr[i] > arr[j]) && (longestDec[i] < longestDec[j] + 1)) {
					longestDec[i] = longestDec[j] + 1;
				}
			}
		}
		longestBitonicSeq = longestInc[0] + longestDec[0] - 1;
		for(int i=1;i<len;i++) {
			
			if (longestBitonicSeq < longestInc[i]+longestDec[i]-1) {
				longestBitonicSeq = longestInc[i]+longestDec[i]-1;
			}
		}
		System.out.println(longestBitonicSeq);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer[]> al = new ArrayList<Integer[]>();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			Integer[] arr = new Integer[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			} al.add(arr);
		}

		for (Integer[] i : al) {
			findMaxBS(i, i.length);
		}

	}

}
