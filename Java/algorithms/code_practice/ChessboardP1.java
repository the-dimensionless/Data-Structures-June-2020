package code_practice;

import java.util.Scanner;

public class ChessboardP1 {

	static String finalAns = "";
	static int count = 0;
	public static void possibleWays(int arr[][], int n, int x, int y, String res) {
		if(x>n && y>n) {
			return;
		}
		
		if(x <= n && y <= n) {
			
			if(x==(n) && y==(n)) {
				finalAns += res+" ";
				count++;
				return;
			}
			
			// Try Knight
			String knight1 = new String(res);
			String knight2 = new String(res);
			knight1 += "K{"+(x+2)+"-"+(y+1)+"}";	
			possibleWays(arr, n, x+2, y+1, knight1);
			knight2 += "K{"+(x+1)+"-"+(y+2)+"}";
			possibleWays(arr, n, x+1, y+2, knight2);
			
			//Try a rook
			if(x==n || y==n || x==0 || y==0) {
				for(int i=1; i<=n-x;i++) {
					String rook1 = new String(res);
					rook1 += "R{"+(x+i)+"-"+y+"}";
					possibleWays(arr, n, x+i, y, rook1);
				}
				for(int i=1; i<=n-x;i++) {
					String rook2 = new String(res);
					rook2 += "R{"+(x)+"-"+(y+i)+"}";
					possibleWays(arr, n, x, y+i, rook2);
					
					if(rook2.equals("{0-0}K{2-1}")) {
						System.out.println("found");
					}
				}
			}
			
			// Try a bishop
			if (x==y || (x+y) == n) {
				for(int i = 1; i<=n-x; i++) {
					String bishop = new String(res);
					bishop += "B{"+(x+i)+"-"+(y+i)+"}"; possibleWays(arr, n, x+i, y+i, bishop);
				}
			}
		}
	}
	public static void printWays(int arr[][], int n) {
		int xi = 0; int yi = 0;
		possibleWays(arr, n, xi, yi, "{0-0}");
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int arr[][] = new int[n][n];
		printWays(arr, n-1);
		System.out.println(finalAns);
		System.out.println(count);
	}

}
//{0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2} {0-0}R{0-1}K{2-2} {0-0}R{0-1}R{0-2}R{1-2}R{2-2} {0-0}R{0-1}R{0-2}R{2-2} {0-0}R{0-1}R{1-1}B{2-2} {0-0}R{0-1}R{2-1}R{2-2} {0-0}R{0-2}R{1-2}R{2-2} {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2} {0-0}R{1-0}R{1-1}B{2-2} {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2} {0-0}R{1-0}R{2-0}R{2-2} {0-0}R{2-0}R{2-1}R{2-2} {0-0}R{2-0}R{2-2} {0-0}B{1-1}B{2-2} {0-0}B{2-2}