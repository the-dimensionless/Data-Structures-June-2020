package hackCodeBlocks;

import java.util.Scanner;

public class BookAllocationMethod {

	public static boolean isValidConfig(long books[], int n, int k, long ans) {
		
		int student = 1;
		long currPages = 0l;
		
		for(int i=0; i<n;i++) {
			if(currPages + books[i] > ans) {
				currPages = books[i];
				student +=1;
				if(student > k) {
					return false;
				}
			} else {
				currPages += books[i];
			}
		}
		
		return true;
		
	}
	public static int binarySearchBooks(long books[], int n, int k) {
		
		long totalPages = 0l;
		long start = 0l; long end = 0l;
		for(int i=0;i<n;i++) {
			totalPages += books[i];
			 start = (int) Math.max(start, books[i]);
		}
		end = totalPages;
		int finalans = (int) start;
		
		while(start <= end) {
			long mid = (start+end)/2;
			if(isValidConfig(books, n, k, mid)) {

				finalans = (int) mid;
				end = mid-1;
			} else {
				start = mid+1; 
			}
		}
		return finalans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		for(int j = 0; j<t; j++) {
			int n = kb.nextInt();
			int m = kb.nextInt();
			
			long arr[] = new long[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = kb.nextLong();
			}
			
			System.out.println(binarySearchBooks(arr, n, m));
		}
		

	}

}
