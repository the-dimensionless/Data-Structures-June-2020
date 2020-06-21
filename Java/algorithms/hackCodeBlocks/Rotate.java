package hackCodeBlocks;

import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int arr[][] = new int[N][N];
		int res[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=kb.nextInt();
			}
		}
		int row = 0;
		for(int i=N-1; i>=0; i--) {
			for(int j =0; j<N; j++) {
				System.out.print(arr[j][i]+" ");
			}
			System.out.println();
		}


	}

}
