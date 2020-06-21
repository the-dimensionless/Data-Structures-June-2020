package code_practice;

import java.util.Scanner;

public class MaximumSubArray {

	public static void findMaxSub(int a[]) {
		
		long global = 0;
		int board[][] = new int[a.length+1][a.length+1];
		for(int i=0;i<a.length;i++) {
			board[0][i] = 0;
			board[i][0] = 0;
		}
		global = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			long locale = a[i];
			for(int j=i+1;j<a.length;j++) {
				locale += a[j];
				
				if(locale > global) {
					global = locale;
				}
			}
		}
		System.out.println(global);
		
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int test = kb.nextInt();
		for (int i = 0; i < test; i++) {
			int n = kb.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = kb.nextInt();
			}
			findMaxSubOn(arr);
		}

	}
	public static void findMaxSubOn(int a[]) {
		
		int localMaxima = a[0];
		int globalMaxima = a[0];
		
		for(int i=1; i<a.length; i++) {
			
			localMaxima += a[i];
			if(localMaxima < a[i]) {
				localMaxima = a[i];
			}
			
			if(globalMaxima < localMaxima) {
				globalMaxima = localMaxima;
			}
		}
		System.out.println(globalMaxima);
	}
	public int maxSubArray(int[] nums) {
        if(nums.length==0 || nums==null)
            return -1;
        int currentSum=nums[0], maxSum=nums[0];
        for(int i=1;i<nums.length;i++) {
            currentSum+=nums[i];
            if(currentSum<nums[i])
                currentSum=nums[i];
            if(maxSum<currentSum)
                maxSum=currentSum;
        }
        return maxSum;
    }
	
	
}
