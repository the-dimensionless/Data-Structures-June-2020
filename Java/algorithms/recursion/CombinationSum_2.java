package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given an array of integers A and a sum B, find all unique combinations in A
 * where the sum is equal to B. Each number in A may only be used once in the
 * combination. Note: All numbers will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The combinations themselves must be sorted in ascending order. If
 * there is no combination possible the print "Empty" (without quotes). Example,
 * Given A = 10,1,2,7,6,1,5 and B(sum) 8, A solution set is: [1, 7] [1, 2, 5]
 * [2, 6] [1, 1, 6]
 * 
 * @author sumitsingh
 *
 */
public class CombinationSum_2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int testCases = kb.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = kb.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = kb.nextInt();
			}
			int target = kb.nextInt();
//			System.out.println("no of ele -> "+n+" and target is -> "+target + " and array is "+Arrays.toString(arr));
			Set<String> set = new HashSet<String>();
			findSOS(arr, 0, "", target, 0, n, set);
			System.out.println();
//			System.out.println();
		}
		kb.close();

	}

	private static void findSOS(int[] arr, int sum, String string, int target, int i, int n, Set<String> set) {
		if (i >= n) {
			if (sum == target) {
				char a[] = string.toCharArray();
				Arrays.sort(a);
				String res = Arrays.toString(a).replaceAll(",", " ").replace("[", "(").replace("]", ")");
				set.add(res);
//				System.out.print(res);
			}
			return;
		}

		int currVal = arr[i];
		if (currVal + sum <= target) {
			findSOS(arr, sum + currVal, string + String.valueOf(currVal), target, i + 1, n, set);
		}
		findSOS(arr, sum, string, target, i + 1, n, set);
	}

}
