package code_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumLengthBitonicArray {
		static int findLength(int arr[], int n) 
		{ 
			int[] increasingSubs = new int[n]; 
			int[] decreasingSubs = new int[n]; 
			int max; 
			increasingSubs[0] = 1; 
			decreasingSubs[n-1] = 1; 

			for (int i = 1; i < n; i++) 
			increasingSubs[i] = (arr[i] >= arr[i-1])? increasingSubs[i-1] + 1: 1; 

			for (int i = n-2; i >= 0; i--) 
				decreasingSubs[i] = (arr[i] >= arr[i+1])? decreasingSubs[i+1] + 1: 1; 

			max = increasingSubs[0] + decreasingSubs[0] - 1; 
			for (int i = 1; i < n; i++) 
				if (increasingSubs[i] + decreasingSubs[i] - 1 > max) 
					max = increasingSubs[i] + decreasingSubs[i] - 1; 

			return max; 
		} 
		
		public static void main (String[] args) 
		{ 	Scanner kb = new Scanner(System.in);
			ArrayList<Integer> a = new ArrayList<Integer>();
			
			int t = kb.nextInt();
			for(int i=0;i<t;i++) {
				int n = kb.nextInt();
				int arr[]=new int[n];
				for(int j=0;j<n;j++) {
					arr[j] = kb.nextInt();
				}
				a.add(findLength(arr,n));
			}
			for(Integer x : a) {
				System.out.println(x);
			}
		} 


}
