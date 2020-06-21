package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class NumberOfPaths {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCases; i++) {
			Integer arr[] = Stream.of(br.readLine().split(" ")).mapToInt(j -> Integer.parseInt(j)).boxed()
	                .toArray(Integer[]::new);
//			System.out.println(countPaths (1 , 1, arr[0], arr[1]));
			System.out.println(countPathsConveniently(arr[0], arr[1]));
		}
	}
	
	public static int countPaths (int a, int b, int m, int n) {		
		if (a < m && b < n)
			return countPaths (a+1, b, m, n) + countPaths (a, b+1, m, n);
		else if (a < m && b == 0)
			return countPaths (a+1, b, m, n);
		else if (b < n && a == 0)
			return countPaths (a, b+1, m, n);
		else if (a>m && b>n)
			return 0;
		else return 1;
	}
	
	public static int countPathsConveniently (int m, int n) {
		
		if (m==1 || n==1)
			return 1;
		
		return countPathsConveniently(m-1, n) + countPathsConveniently(m, n-1);
//				countPathsConveniently(m-1, n-1);
	}

}
