package arrays;

import java.util.Scanner;

public class MissingNumber {
	// Method 1 : Find Sn - S(n-1)
	// Method 2 : Using XOR 

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		for (int i = 0; i < n; i++) {
			
			int l = kb.nextInt();
			int arr[] = new int[l];

			for (int j=0; j<l-1; j++) {
				arr[j] = (kb.nextInt());
			}
			findMissing(arr, l);
		}
		kb.close();
	}

	private static void findMissing(int[] arr, int l) {
		
		int num1 = arr[0];
		int num2 = 1;
		
		for (int i = 1; i < l-1; i++) {
			
			num1 = num1 ^ arr[i];
		}
		
		for (int i = 2; i <= l; i++) {
			
			num2 = num2 ^ i;
		}
		
		System.out.println(num1 ^ num2);
	}

}
