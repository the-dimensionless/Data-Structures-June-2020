package hackCodeBlocks;

import java.util.Arrays;
import java.util.Scanner;

public class MedianOFbst {

	public static void findMedian(int arr[], int len) {
		Arrays.sort(arr);
		int median = 0;
		if (len%2 == 0) {
			median = arr[len/2]+arr[(len+1)/2];
			median /= 2;
		} else {
			median = arr[len/2];
		}
		System.out.println(median);
	}
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n;i++) {
			arr[i] = kb.nextInt();
		}
		findMedian(arr, arr.length);

	}

}
