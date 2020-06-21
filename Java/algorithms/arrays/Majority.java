package arrays;

import java.util.Scanner;

/*
 * Given an array A of N elements. Find the majority element in the array.
 *  A majority element in an array A of size N is an element that appears 
 *  more than N/2 times in the array.
 */
public class Majority {
	
	// M1 : Using a HashMap, we get T->O(n), S->O(n)
	// M2 : Using Moore's voting Algorthim, we get T->O(n), S->O(1)
	// M3 : Sort and count If any element is N/2 times in frequency

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		for (int i = 0; i < n; i++) {
			
			int l = kb.nextInt();
			int arr[] = new int[l];

			for (int j=0; j<l; j++) {
				arr[j] = (kb.nextInt());
			}
			findMajorityByMooresAlgorithm(arr, l);
		}
		kb.close();

	}

	private static void findMajorityByMooresAlgorithm (int[] nums, int l) {
		int result = 0, count = 0;
		 
	    for(int i = 0; i<nums.length; i++ ) {
	        if(count == 0){
	            result = nums[ i ];
	            count = 1;
	        }else if(result == nums[i]){
	           count++;
	        }else{
	           count--;
	        }
	    }
	 
	    if (count < l/2) {
	    	System.out.println(-1);
	    } else {
	    	System.out.println(result);
	    }
//		display(arr, l);
	}
	
	private static int findCandidate (int arr[], int n) {
		
		int max_index = 0;
		int count = 1;
		
		for (int i = 0; i < n; i++) {
			
			if (arr[max_index] == arr[i]) {
				count++;
			} else {
				count--;
			}
			
			if (count == 0) {
				max_index = i;
				count = 1;
			}
		}
		
		return arr[max_index];
	}
	
	static boolean isMajority (int arr[], int n, int candidate) {
		
		int count = 0;
		for (int j = 0; j < n ; j++) {
			if (arr[j] == candidate) {
				count++;
			}
		}
		if (count > n/2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void display (int arr[], int n) {
		int candidate = findCandidate(arr, n);
		
		if (isMajority(arr, n, candidate)) {
			System.out.println(candidate);
		} else {
			System.out.println(-1);
		}
	}

}
