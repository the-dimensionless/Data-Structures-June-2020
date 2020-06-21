package hackCodeBlocks;

import java.util.Scanner;

public class MaximumCircularSum {

	public static void findMaxCS(int arr[], int len) {
		int globalsum = Integer.MIN_VALUE;
		int limit = len-2;
		
		for(int i=0; i<len; i++) {
			int sum = arr[i];		
			int rounds = 0;
			for(int j=(i+1)%len; rounds <= limit; j = (j+1)%len) {
				sum += arr[j];		
				rounds++;
				if(sum > globalsum) {
					globalsum = sum;
				}
			}
		}
		System.out.println(globalsum);
		
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = kb.nextInt();
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j] = kb.nextInt();
			}
			findMaxCS(arr, arr.length);
		}

	}

}
