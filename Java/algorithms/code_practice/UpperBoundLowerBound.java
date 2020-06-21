package code_practice;

import java.util.Scanner;

public class UpperBoundLowerBound {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		int q = kb.nextInt();
		int queries[] = new int[q];
		for (int i = 0; i < q; i++) {
			queries[i] = kb.nextInt();
		}
		for (int i = 0; i < q; i++) {
			findUpperAndLowerBound(arr, n, queries[i]);
		}
	}

	private static void findUpperAndLowerBound(int[] arr, int n, int num) {
		int lowerB = -1, upperB = -1;
		for (int i = 0; i < n; i++) {
			if (num != arr[i]) {
				continue;
			}
			if (lowerB == -1) {
				lowerB = i;
			}
			upperB = i;
		}
		System.out.println(lowerB + " " + upperB);
	}

}
