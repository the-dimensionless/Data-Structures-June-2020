package hackCodeBlocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AlphaScore {

	static ArrayList<Integer> ar = new ArrayList<Integer>();
	
	public static void findAlphaScore(int[] a, int len, int current) {
		
		int sumTable[][] = new int[len+1][len+1];
		for(int i=0;i<len;i++) {
			sumTable[0][i] = 0;
		}
		
		for(int i=0;i<len;i++) {
			sumTable[i][0] = 0;
		}
		
		for(int i = 1; i<len; i++) {
			for(int j = 1; j<len; j++) {
				
				for(int k = 1; k<j; k++) {
					sumTable[i][j] += sumTable[i][k];
				}
			}
		}
		System.out.println(sumTable[len][len]);
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");
		int a[] = new int[N];
		
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		findAlphaScore(a, a.length, 0);
	
	}

}
