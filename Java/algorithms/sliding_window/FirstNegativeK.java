package sliding_window;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNegativeK {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		
		for(int i=0;i <t; i++) {
			int n = kb.nextInt();
			int k = kb.nextInt();
			
			int arr[] = new int[n];
			
			for(int j=0;j<n;j++) {
				arr[j] = kb.nextInt();
			}
			
			findFirstNeg(arr, arr.length, k);
			kb.close();
		}
		
	}

	private static void findFirstNeg(int[] arr, int length, int k) {
		int i = 0;
		Deque<Integer> q = new LinkedList<Integer>();
		
		for( i=0; i<k; i++) {
			
			if(arr[i] < 0) {
				q.add(i);
			}
		}
		for( ; i<length; i++) {
			
			if (!q.isEmpty()) {
				if (arr[q.peek()] < 0)
					System.out.print(arr[q.peek()]+" ");
				else System.out.print("0 ");
			}
			
			while( (!q.isEmpty()) && (q.peek() < (i-k+1))) {
				q.remove();
			}
			
			if (arr[i] < 0) {
				q.add(i);
			}
		}
		
		if (q.isEmpty() == false) {
			if (arr[q.peek()] < 0)
				System.out.print(arr[q.peek()]+" ");
			else System.out.print("0 ");
		} else {
			System.out.println("0 ");
		}
		
	}

}
