package code_practice;

import java.util.Scanner;

public class Chessboard2 {

	static String finalAns = "";
	static int count = 0;

	public static void possibleWays(int arr[][], int n, int x, int y, String res) {
		
		
		if (x > n && y > n) {
			return;
		}

		if (x <= n && y <= n) {

			if (x == (n) && y == (n)) {
				finalAns += res + " ";
				count++;
				System.out.println(res);
				return;
			}

			// Try Knight
			String knight1 = new String(res);
			String knight2 = new String(res);
			knight1 += "K{" + (x + 2) + "-" + (y + 1) + "}";
			possibleWays(arr, n, x + 2, y + 1, knight1);
			knight2 += "K{" + (x + 1) + "-" + (y + 2) + "}";
			possibleWays(arr, n, x + 1, y + 2, knight2);

			// Try a rook
			if (x == n || y == n || x == 0 || y == 0) {

				String rook2 = new String(res);
				rook2 += "R{" + (x) + "-" + (y + 1) + "}";
				possibleWays(arr, n, x, y + 1, rook2);	System.out.println(rook2);

				String rook1 = new String(res);
				rook1 += "R{" + (x + 1) + "-" + y + "}";
				possibleWays(arr, n, x + 1, y, rook1);	System.out.println(rook1);
				
				for(int i=2; i<n-1;i++) {
					rook2 = new String(res);
					rook2 += "R{" + (x) + "-" + (y + i) + "}";
					possibleWays(arr, n, x, y + i, rook2);	System.out.println(rook2);

					rook1 = new String(res);
					rook1 += "R{" + (x + i) + "-" + y + "}";
					possibleWays(arr, n, x + i, y, rook1);	System.out.println(rook1);
				}

			}

			// Try a bishop
			if (x == y || (x + y) == n) {
				for (int i = 1; i <= n - x; i++) {
					String bishop = new String(res);
					bishop += "B{" + (x + i) + "-" + (y + i) + "}";
					possibleWays(arr, n, x + i, y + i, bishop);	System.out.println(bishop);
				}
			}
		}
	}

	public static void printWays(int arr[][], int n) {
		int xi = 0;
		int yi = 0;
		possibleWays(arr, n, xi, yi, "{0-0}");
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr[][] = new int[n][n];
		printWays(arr, n - 1);
		System.out.println(finalAns);
		System.out.println(count);
	}

}