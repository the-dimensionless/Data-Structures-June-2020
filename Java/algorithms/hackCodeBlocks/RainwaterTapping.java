package hackCodeBlocks;

import java.util.Scanner;

public class RainwaterTapping {

	public static void findTapping(int arr[], int len, int max) {
		int totalAmount = 0;int leftLimit = 0;
		int rightLimit = 0;int curr = 0;
		int localMax = len - 1;

		while (curr <= localMax) {
			if (arr[curr] < arr[localMax]) {
				if (arr[curr] > leftLimit) {
					leftLimit = arr[curr];
				} else {
					totalAmount += leftLimit - arr[curr];
				}
				curr = curr + 1;
			} else {
				if (arr[localMax] > rightLimit) {
					rightLimit = arr[localMax];
				} else {
					totalAmount += rightLimit - arr[localMax];
				}
				localMax = localMax - 1;
			}

		}
		System.out.println( totalAmount);

	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		for (int i = 0; i < t; i++) {
			int n = kb.nextInt();
			int max = Integer.MIN_VALUE;
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = kb.nextInt();
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			findTapping(arr, arr.length, max);

		}

	}

}
