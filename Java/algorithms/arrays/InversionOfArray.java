package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Given an array of positive integers. The task is to find inversion count of array.
 * Inversion Count : For an array, inversion count indicates how far (or close) the array is 
 * from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 */
public class InversionOfArray {

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
//			inversion(arr, len);
			System.out.println(mergeSortCount(arr, 0, len-1));
		}


	}

	private static int mergeSortCount(int[] arr, int start, int end) {
		
		int countInversionsCurrentNode = 0;
		
		if (start < end) {
			int mid = (start + end) / 2;
			
			countInversionsCurrentNode += mergeSortCount(arr, start, mid);
			countInversionsCurrentNode += mergeSortCount(arr, mid+1, end);
			
			countInversionsCurrentNode += mergeCount(arr, start, mid, end);
		}
		
		return countInversionsCurrentNode;
	}

	private static int mergeCount(int[] arr, int start, int mid, int end) {
		
		// left Subarray
		int left[] = Arrays.copyOfRange(arr, start, mid+1);
		int rightp[] = Arrays.copyOfRange(arr, mid+1, end+1);
		
		int i=0, j=0, k=start, swaps = 0;
		
		while (i < left.length && j < rightp.length) {
			if (left[i] <= rightp[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = rightp[j++];
				swaps += (mid+1) - (start+i);
			}
		}
		
		while (i < left.length) {
			arr[k++] = left[i++];
		}
		
		while (j < rightp.length) {
			arr[k++] = rightp[j++];
		}
		
		return swaps;
	}

	@SuppressWarnings("unused")
	private static void inversion(int[] arr, int len) {
		int count = 0;
		
		for (int i = 0; i < len; i++) {
			int see = arr[i];
			for (int j = i+1; j < len; j++) {
				if (see > arr[j]) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}

}
