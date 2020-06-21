package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an array A of size N containing 0s, 1s, and 2s; 
 * you need to sort the array in ascending order.
 */
public class SortArraysOf012 {
	/*
	 * Method 1 : Count them and print them
	 * Method 2 : Dutch National Flag Problem (3-way partitioning)
	 * Method 3 : 
	 */

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
			sortDutchNationalFlag(arr, len);
		}
	}

	private static void sortDutchNationalFlag(int[] arr, int len) {
		
		int low = 0;
		int high = len - 1;
		int mid = 0;
		int temp = 0;
		
		while (mid <= high) {
			switch (arr[mid]) {
			
			case 0: {
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				low++;
				mid++;
				break;
			}
			case 1: {
				mid++;
				break;
			}
			case 2: {
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
				break;
			}
		}
	}
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
