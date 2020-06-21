package sliding_window;

import java.util.Scanner;
import java.util.Stack;

public class HistogramsFinal {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextLong();
		}
		findHist(arr, arr.length);
		kb.close();

	}

	private static void findHist(long[] arr, int len) {
		long globalMaxArea = 0l;

		Stack<Integer> st = new Stack<Integer>();

		int currBar = 0;
		long localArea = 0l;

		while (currBar < len) {

			if (st.isEmpty()) {
				st.push(currBar);
				currBar = currBar + 1;
			} else if (arr[currBar] > st.peek()) {
				st.push(currBar);
				currBar = currBar + 1;
			} else {
				long height = arr[st.pop()];
				int rightMax = currBar;

				if (st.isEmpty()) {
					localArea = rightMax * height;
				} else {
					int leftMax = st.peek();
					localArea = (rightMax - leftMax - 1) * height;
				}

				if (localArea > globalMaxArea) {
					globalMaxArea = localArea;
				}
			}
		}
		
		while (!st.isEmpty()) {
			long height = arr[st.pop()];
			int rightMax = currBar;
			
			if(st.isEmpty()) {
				localArea = rightMax * height;
			} else {
				int leftMax = st.peek();
				localArea = (rightMax - leftMax - 1) * height;
			}
			
			if (localArea > globalMaxArea) {
				globalMaxArea = localArea;
			}
		}
		
		System.out.println(globalMaxArea);
	}
}
