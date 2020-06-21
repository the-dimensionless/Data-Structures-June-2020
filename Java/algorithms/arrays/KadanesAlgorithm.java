package arrays;

import java.util.Scanner;

/*
 * Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 */

public class KadanesAlgorithm {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		for (int i = 0; i < n; i++) {
			
			int l = kb.nextInt();
			int arr[] = new int[l];

			for (int j=0; j<l; j++) {
				arr[j] = (kb.nextInt());
			}
			findMaxSubArraySum(arr, l);
		}
		kb.close();

	}

	private static void findMaxSubArraySum(int arr[], int size) {

		Integer sum = 0;
		Integer best = Integer.MIN_VALUE;
		
		
		for(int i=0; i<size; i++) {
			int integer = arr[i];
			sum = Math.max(integer, (sum + integer));
			
			best = Math.max(best, sum);
		}

		
		
		if (best == Integer.MIN_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(best);
		}


	}

}
