package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an unsorted array A of size N of non-negative integers, 
 * find a continuous sub-array which adds to a given number S.
 */
public class SubarrayWithGivenSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			String c[] = br.readLine().split(" ");
			int len = Integer.parseInt(c[0]);
			int max = Integer.parseInt(c[1]);
			int arr[] = new int[len];
			String s[] = br.readLine().split(" ");
			for (int j=0; j<len; j++) {
				arr[j] = Integer.parseInt(s[j]);
			}
			findSubarray(arr, len, max);
		}

	}

	private static void findSubarray(int[] arr, int n, int sum) {
		/*
		 * Sliding Window Protocol
		 */
		int curr_sum = arr[0], start = 0, i; 
		  
        // Pick a starting point 
        for (i = 1; i <= n; i++)  
        { 
            // If curr_sum exceeds the sum, then remove the starting elements 
            while (curr_sum > sum && start < i-1) 
            { 
                curr_sum = curr_sum - arr[start]; 
                start++; 
            } 
              
            // If curr_sum becomes equal to sum, then return true 
            if (curr_sum == sum)  
            { 
                int p = i; 
                System.out.println( (start+1)
                        + " " + p); 
                return ; 
            } 
              
            // Add this element to curr_sum 
            if (i < n) 
            curr_sum = curr_sum + arr[i]; 
              
        } 
  
        System.out.println(-1);
		
	}

}
