package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an array A of N positive numbers. The task is to find the position where equilibrium
 *  first occurs in the array. Equilibrium position in an array is a position such 
 *  that the sum of elements before it is equal to the sum of elements after it.
 */
public class EquilibriumPoint {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			int len = Integer.parseInt(br.readLine());
			int arr[] = new int[len];
			String s[] = br.readLine().split(" ");
			for (int j=0; j<len; j++) {
				arr[j] = Integer.parseInt(s[j]);
			}
			findEqui(arr, len);
		}

	}

	private static void findEqui(int[] arr, int len) {

		if (len == 1) {
			System.out.println(1);
			return;
		}
		
		int leftSum[] = new int [len];	leftSum[0] = 0;
		int rightSum[] = new int[len]; 	rightSum[len-1] = 0;
		
		for (int i = 1; i < len; i++) {
			leftSum[i] = leftSum[i-1] + arr[i-1];
//			System.out.println("AT i = "+i+" left sum is "+leftSum[i]);
		}
		
		for (int i = len-2; i >= 0; i--) {
			rightSum[i] = rightSum[i+1] + arr[i+1];
		}
		
		for (int i=0; i<len; i++) {
			if (leftSum[i] == rightSum[i]) {
				System.out.println((i+1));
				return;
			}
		}
		
		for (int i=0; i<len; i++) {
			System.out.print(leftSum[i] + " ");
		}
		System.out.println();
		for (int i=0; i<len; i++) {
			System.out.print(rightSum[i] + " ");
		}
		
		System.out.println(-1);
		
	}

}
