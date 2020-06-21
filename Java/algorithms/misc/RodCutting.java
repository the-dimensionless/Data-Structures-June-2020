package misc;
import java.util.ArrayList;

public class RodCutting {

	public static void main(String[] args) {
		int len[] = {1,2,3,4,5,6,7,8};
		int price[] = {1,5,8,9,10,17,17,20};
		int price2[] = {3,1,5,8,9,10,17,17,20};
		
		System.out.println(findValueRecursively(len, 0, price, 0, new ArrayList<Integer>()));
		System.out.println(findValueRecursively(len, 0, price2, 0, new ArrayList<Integer>()));

	}
	
	static int maxScore = 0;
	public static int findValueRecursively(int len[], int currLen, int price[], int currPrice, ArrayList<Integer> cuts) {
		
		if (currLen >= len.length) {
			return 0;
		}
		
		ArrayList<Integer> newCuts = new ArrayList<Integer>(cuts);
		
		return Math.max( findValueRecursively(len, currLen+1, price, currPrice+price[currLen], newCuts)
				, findValueRecursively(len, currLen, price, currPrice, cuts));
	}

}
