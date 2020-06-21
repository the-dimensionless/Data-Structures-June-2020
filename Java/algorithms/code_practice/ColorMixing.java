package code_practice;

public class ColorMixing {

	static int MatrixChainDp(int a[], int si, int ei) {
		if(si == ei) {
			return 0;
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i=si;i<ei-1;i++) {
			int m1 = MatrixChainDp(a, si, i);
			int m2 = MatrixChainDp(a, i+1, ei);
//			int m3 = color(a, si, i) + color(a, i+1, ei);
//			int tsmoke = m1+m2+m3;
//			if(tsmoke < ans) {
//				ans = tsmoke;
//			}
		}
		return ans;
	}
	public static long color(int a[], int i, int ei) {
		long s = 0;
		for(int j = i; j<ei;j++) {
			s += a[j];
		}
		return s;
	}

	public static void main(String[] args) {
		int arr[] = { 40, 60, 20 };
		int arr2[] = {10,20,30,40,50,60};
		
//		System.out.println(MatrixChainRec(arr, 1, arr.length-1));
		System.out.println(MatrixChainDp(arr, 0, arr.length));
//		System.out.println(MatrixChainRec(arr2, 1, 5));

	}

}
