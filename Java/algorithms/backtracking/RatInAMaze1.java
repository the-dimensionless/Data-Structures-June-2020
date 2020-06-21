package backtracking;

import java.util.Scanner;

public class RatInAMaze1 {
	
	public static boolean solutionExists = false;
	
	public static int[][] getMatrix(String in[], int n) {
		int arr[][] = new int [n][n];
		int k=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(in[k]);
				k++;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int testCases = Integer.parseInt(kb.nextLine());
		for (int i = 0; i < testCases; i++) {
			int size = Integer.parseInt(kb.nextLine());
			String input[] = kb.nextLine().split(" ");
			int matrix[][] = getMatrix(input, size);
			findPaths(matrix, size);
		}
		kb.close();
	}
	
	public static void findPaths(int matrix[][], int size) {
		findRecursively(matrix, size, 0, 0, "");
		if (solutionExists == false) {
			System.out.println(-1);
		}
	}
	
	public static void findRecursively(int matrix[][], int size, int i, int j, String s) {
		
		if (i == size-1 && j==size-1) {
			System.out.println(s);
			solutionExists = true;
			return;
		}
		
		if ((i+1 != size) && matrix[i+1][j] != 0) {
			findRecursively(matrix, size, i+1, j, s+"D");
		}
		
		if ((j+1!=size) && matrix[i][j+1] !=0) {
			findRecursively(matrix, size, i, j+1, s+"R");
		}
		
		
		if ((i-1>=0) && matrix[i-1][j] !=0) {
			findRecursively(matrix, size, i, j+1, s+"U");
		}
		
		if ( (j-1>=0) && matrix[i][j-1] !=0) {
			findRecursively(matrix, size, i, j+1, s+"L");
		}
		
		
	}

}
