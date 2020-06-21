package dynamic_prog;

import java.util.ArrayList;

/*
 * Find number of ways to partition a set
 */
public class bellNumbers {

	public static int numberOfPartitions(int n) {
		int dp[][] = new int[n+1][n+1];
		dp[0][0] = 1;
		
		
		for(int i=1; i<=n;i++) {
			dp[i][0] = dp[i-1][i-1];
			
			for(int j=1; j<=i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
			}
		}
		return dp[n][0];
	}
	
	static int count = 0;
	
	public void findPartitions(int arr[], int index, ArrayList<ArrayList<Integer>> a) {
		if (index > arr.length)
			return;
		if (index == arr.length) {
			System.out.println(a);
			count++;
			return;
		}
		
		int val = arr[index];
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(val);
		ArrayList<ArrayList<Integer>> acopy2 = new ArrayList<ArrayList<Integer>>(a);
		acopy2.add(a1);
		findPartitions(arr, index+1, acopy2);
		for(ArrayList<Integer> x : a) {
			
			ArrayList<Integer> tmp = new ArrayList<Integer>(x);
			tmp.add(val);
			ArrayList<ArrayList<Integer>> acopy = new ArrayList<ArrayList<Integer>>(a);
			acopy.remove(x);
			acopy.add(tmp);
			findPartitions(arr, index+1, acopy);
		}
	}
	
	public static long getTime() {
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		
		int arr[] = { 1,2,3,4,5,6,7,8,9,10};
		long start = 0l; long end = 0l;
		
		start = getTime();
		new bellNumbers().findPartitions(arr, 0, new ArrayList<ArrayList<Integer>>());
		System.out.println("count is "+count);
		end = getTime();
		System.out.println("Time taken is : "+(end-start));
		
//		System.out.println("count should be "+numberOfPartitions(3));
		

	}

}
