package hackCodeBlocks;

import java.util.Scanner;

public class MinimumJumps {

	public static int findMin(int arr[], int len) {
		if (arr.length <= 1)
			return 0;
		if (arr[0] == 0)
			return -1;
		int farthestLimit = arr[0];
		int localJump = arr[0];
		int steps = 1;
		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1)
				return steps;
			farthestLimit = Math.max(farthestLimit, i + arr[i]);
			localJump--;
			if (localJump == 0) {
				steps++;
				if (i >= farthestLimit)
					return -1;
				localJump = farthestLimit - i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = kb.nextInt();

		System.out.println(findMin(arr, arr.length));
	}

}
