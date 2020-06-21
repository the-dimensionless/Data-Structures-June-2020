package hackCodeBlocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalGameStrategy {

	public static int find(int a[],int front, int end, int sum, int len) {
		int localX = findMax(a,front+1,end,sum + a[front], len );
		int localY = findMax(a,front,end-1,sum + a[end], len );
		return Math.max(localX, localY);
		
	}
	public static int findMax(int a[],int front, int end, int sum, int len) {
		int X = 0;
		int Y = 0;
		if (front>=end) {
			return a[front];
		}
		for(int i=0;i<len;i = i+2) {
			X += a[i];
		}
		for(int i=0;i<len;i = i+2) {
			Y += a[i];
		}
		int localX = 0;
		int localY = 0;
		if (X > Y) {
			// all odd next
			localX = find(a,front+1,end,sum + a[front], len );
			return localX;
			
		} else if (X < Y) {
			// all even next
			localY = find(a,front,end-1,sum + a[end], len );
			return localY;
			
		} else {
			return X;
		}
	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int coint = Integer.parseInt(br.readLine());
		String arr[] = br.readLine().split(" ");
		int a[] = new int[coint];
		for (int i = 0; i < coint; i++) {
			a[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(findMax(a, 0, coint-1, 0, coint));

	}

}
