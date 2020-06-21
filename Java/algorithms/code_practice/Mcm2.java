package code_practice;

class Mcm2 {
	static int MatrixChain(int a[], int n) {
		int m[][] = new int[n][n];

		int i, j, k, L, q;
		for (i = 1; i < n; i++)
			m[i][i] = 0;

		// L is chain length.
		for (L = 2; L < n; L++) {
			for (i = 1; i < n - L + 1; i++) {
				j = i + L - 1;
				if (j == n)
					continue;
				m[i][j] = Integer.MAX_VALUE;
				for (k = i; k <= j - 1; k++) {
					// q = cost/scalar multiplications
					q = m[i][k] + m[k + 1][j] + a[i - 1] * a[k] * a[j];
					if (q < m[i][j])
						m[i][j] = q;
				}
			}
		}

		return m[1][n - 1];
	}

	static int MatrixChainRec(int a[], int start, int end) {

		if (start == end) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = start; i < end; i++) {
			int cost1 = MatrixChainRec(a, start, i);
			int cost2 = MatrixChainRec(a, i + 1, end);
			int cost3 = a[start - 1] * a[i] * a[end];
			int totalCost = cost1 + cost2 + cost3;
			if (totalCost < min) {
				min = totalCost;
			}
		}
		return min;
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr[] = new int[] { 10, 20, 30, 40, 50, 60 };
		int len = arr.length;

		System.out.println(MatrixChain(arr, len));
		System.out.println(MatrixChainRec(arr, 1, len-1));
	}
}