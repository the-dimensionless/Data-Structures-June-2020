package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * Given an array of 0's and 1's your task is to complete the function maxLen which 
 * returns size of the largest sub array with equal number of 0's and 1's. The function 
 * maxLen takes 2 arguments. The first argument is the array A[] and second argument is 
 * the size 'N' of the array A[].
 */
public class LargestSubarrayOfZerosAndOnes {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int len = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			int arr[] = new int[len];
			for (int j = 0; j < len; j++) {
				arr[j] = Integer.parseInt(s[j]);
			}
//			findLargestSubArray(s, len);
//			trickyMethod(arr);
			ifSoSimpleThenRun(arr);
			
		}

	}

	@SuppressWarnings("unused")
	private static int trickyMethod(int arr[]) {
		/*
		 * T->O(n), S->O(n) : Standard Method
		 */
		int n = arr.length;
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result
		int ending_index = -1;
		int start_index = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == 0) ? -1 : 1;
		}
		
		 for (int i = 0; i < n; i++)  
	        { 
	            // Add current element to sum 
	   
	            sum += arr[i]; 
	            
	         // To handle sum=0 at last index 
	            
	            if (sum == 0)  
	            { 
	                max_len = i + 1; 
	                ending_index = i; 
	            } 
	            
	            // If this sum is seen before, then update max_len 
	            // if required 
	   
	            if (hM.containsKey(sum + n))  
	            { 
	                if (max_len < i - hM.get(sum + n))  
	                { 
	                    max_len = i - hM.get(sum + n); 
	                    ending_index = i; 
	                } 
	            }  else // Else put this sum in hash table 
	                hM.put(sum + n, i); 
	        } 
			 for (int i = 0; i < n; i++)  
		        { 
		            arr[i] = (arr[i] == -1) ? 0 : 1; 
		        } 
		  
	        int end = ending_index - max_len + 1; 
	        System.out.println(end + " to " + ending_index); 
	  
	        return max_len; 

	}
	
	private static void ifSoSimpleThenRun (int arr[]) {
		/*
		 * Unfinished : Use a hashMap to store the value of Last Seen Sum with same Current Sum Value
		 */
		int len = arr.length;
		int sum = 0;
		int length = 0;
		
		for (int i = 0; i < len; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		
		for (int i = 0; i < len; i++) {
			System.out.println("Current value is "+arr[i]);
			sum += arr[i];
			System.out.println("Current sum is "+sum);
			if (sum == 0) {
				length = i;
			}
		}
		
		System.out.println("length is "+length+1);
		
	}

	@SuppressWarnings("unused")
	private static void findLargestSubArray(String[] arr, int len) {
		/*
		 * Exceeds TimeLimit S->O(1), T->O(n*n)
		 */
		int maxLength = 0;

		for (int i = 0; i < len; i++) {
			int countZeros = 0;
			int start = 0;
			int countOnes = 0;
			int end = 0;

			char ch = arr[i].charAt(0);
			start = i;
			if (ch == '0') {
				countZeros = 1;
			} else if (ch == '1') {
				countOnes = 1;
			}

			for (int j = i + 1; j < len; j++) {
				char ch2 = arr[j].charAt(0);
				if (ch2 == '0') {
					countZeros += 1;
				} else if (ch2 == '1') {
					countOnes += 1;
				}

				if (countZeros == countOnes) {
					end = j;
					if (end - start + 1 > maxLength) {
						maxLength = end - start + 1;
					}
				}
			}
		}

		System.out.println(maxLength);

	}

}
