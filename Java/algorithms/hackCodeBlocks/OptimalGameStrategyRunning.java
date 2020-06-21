package hackCodeBlocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalGameStrategyRunning {
	
	static int optimalSol(int arr[], int n) {
		int board[][] = new int[n][n];
		int gap;
		int x,y,z;
		
		for(gap = 0; gap<n; gap++) {
			for(int i=0, j =gap ; j<n; ++i,++j) {
				x = ((i + 2) <= j) ? board[i + 2][j] : 0; 
                y = ((i + 1) <= (j - 1)) ? board[i + 1][j - 1] : 0; 
                z = (i <= (j - 2)) ? board[i][j - 2] : 0; 
  
                board[i][j] = Math.max(arr[i] + Math.min(x, y),  
                                       arr[j] + Math.min(y, z));
			}
		}
		return board[0][n - 1]; 
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int coint = Integer.parseInt(br.readLine());
		String arr[] = br.readLine().split(" ");
		int a[] = new int[coint];
		for (int i = 0; i < coint; i++) {
			a[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(optimalSol(a, a.length));

	}

}
