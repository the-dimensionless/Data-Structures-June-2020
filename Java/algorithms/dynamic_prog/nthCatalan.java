package dynamic_prog;

public class nthCatalan {

	public int catalanRecursive(int n) {
		int res = 0;

		if (n <= 1) {
			return 1;
		}

		for (int i = 0; i < n; i++) {
			res += catalanRecursive(i) * catalanRecursive(n - i - 1);
		}
		return res;
	}

	public int catalanFormula(int n) {
		int numerator = binomialCoeff(2 * n, n);
		return numerator / (n + 1);
	}

	public int binomialCoeff(int n, int r) {
		int ans = 1;

		if (r > n - r) {
			r = n - r;
		}

		for (int i = 0; i < r; i++) {
			ans *= (n - i);
			ans /= (i + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			System.out.print(new nthCatalan().catalanRecursive(i) + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			System.out.print(new nthCatalan().catalanFormula(i) + " ");
		}

	}

}
