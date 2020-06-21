package misc;

public class MaximumSubarraySum_Kadanes {

	public static void main(String[] args) {
		int arr[] = {-1, 2, 4, -3, 5, 2, -5, 2};
		
		int best = 0; int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum = Math.max(arr[i], sum+arr[i]);
			best = Math.max(sum, best);
		}
		
		System.out.println(best);
	}

}
