package code_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfSubsets {
	static int count = 0;
	static ArrayList<Integer> array = new ArrayList<Integer>();
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int testCases = sc.nextInt();
	        while (testCases-- > 0) {
	            int n = sc.nextInt();
	            int[] arr = new int[n];
	            for (int i = 0; i < n; i++) {
	                arr[i] = sc.nextInt();
	            }
	            if (SOS(arr, 0, 0, false)) {
	                System.out.println("Yes");
	            } else {
	                System.out.println("No");
	            }
	        }

	    }
	    public static boolean SOS(int[] arr, int index, int curr_sum, boolean currentTaken) {
	        if (index == arr.length) {
	            return (curr_sum == 0 && currentTaken == true);
	        }
	        return SOS(arr, index + 1, curr_sum + arr[index], true) 
	        		|| (SOS(arr, index + 1, curr_sum, currentTaken));
	    }


}
