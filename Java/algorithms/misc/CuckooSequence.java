package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuckooSequence {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		findCuckoo(N);
	}

	private static void findCuckoo(int n) {
		
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		
		for (int i = 3; i <= n ; i++) {
			dp[i] = (1 * dp[i-1]) + (2 * dp[i-2]) + (3 * 1);
		}
		
		System.out.println(dp[n]);
		
	}

}
