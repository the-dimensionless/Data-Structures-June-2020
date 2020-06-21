package code_practice;

import java.util.Scanner;

public class PairSumBST {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		int target = kb.nextInt();
		
		for(int i = 0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]+arr[j] == target) {
					System.out.println(arr[i]+" "+arr[j]);
				}
			}
		}
	}

}
