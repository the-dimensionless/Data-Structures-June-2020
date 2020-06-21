package hackCodeBlocks;

public class SudokuSolver {

	public static void view(int arr[][], int M) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void setFixedCells(int[][] arr, boolean fixedCells[][], int M) { // true for if set
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					fixedCells[i][j] = false;
				} else {
					fixedCells[i][j] = true;
				}
			}
		}
	}

	public static boolean SudokuSol(int[][] arr, boolean[][] fixedCells, int row, int col, int M) {
		boolean ans = false;
		if (row == M)
			return true;
		if (col == M)
			return SudokuSol(arr, fixedCells, row + 1, 0, M);

		if (fixedCells[row][col] == true) {
			return SudokuSol(arr, fixedCells, row, col + 1, M);
		}
		for (int i = 1; i <= M; i++) {
			if (canPlace(arr, row, col, i, M)) {
				System.out.println("trying to place "+i+" at "+row+","+"col");
				arr[row][col] = i;
				ans = SudokuSol(arr, fixedCells, row, col + 1, M);
			}
			if (ans == true) {
				System.out.println("Fixed value ");
				return true;
			} else {
				System.out.println("Backtracking. . .");
				arr[row][col] = 0;
			}
		}
		return false;
	}

	public static boolean canPlace(int[][] arr, int row, int col, int setNum, int n) { // is it safe to place
																						// setNum(row,col) ?
		for (int i = 0; i < row; i++) {
			if (arr[i][col] == setNum) {
				return false;
			}
			
			if (arr[row][i] == setNum) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int M = 9;
		int arr[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },

				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },

				{ 0, 6, 0, 0, 0, 0, 2, 1, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 1, 9 } };

		boolean[][] fixedCells = new boolean[M][M];

		setFixedCells(arr, fixedCells, M); // Mark locations of set and unset numbers

		boolean solve = SudokuSol(arr, fixedCells, 0, 0, M);

		if (solve) {
			view(arr, M);
		} else {
			System.out.println("Can't be solved");
		}

	}

}
