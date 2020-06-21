package hackCodeBlocks;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
	static int getMaxArea(int array[], int n) {
		Stack<Integer> stack = new Stack<>();

		int globalMaxArea = 0; 
		int tos; 
		int area_with_top; 
		int i = 0;
		while (i < n) {
			if (stack.empty() || array[stack.peek()] <= array[i])
				stack.push(i++);
			else {
				tos = stack.peek(); 
				stack.pop(); 
				area_with_top = array[tos] * (stack.empty() ? i : i - stack.peek() - 1);
				if (globalMaxArea < area_with_top)
					globalMaxArea = area_with_top;
			}
		}

		while (stack.empty() == false) {
			tos = stack.peek();
			stack.pop();
			area_with_top = array[tos] * (stack.empty() ? i : i - stack.peek() - 1);

			if (globalMaxArea < area_with_top)
				globalMaxArea = area_with_top;
		}

		return globalMaxArea;

	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int arr[]= new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(getMaxArea(arr, N));
	}

}
