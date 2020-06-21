package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumMaxAndMinInArray {
	
	public static void main(String[] args) throws IOException {
		
//		Scanner kb = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer MAX = Integer.MIN_VALUE;
		Integer MIN = Integer.MAX_VALUE;
		
		int testCases = Integer.parseInt(br.readLine());
		
		int arr[] = new int[testCases];
		
		String s[] = br.readLine().split(" ");
		
		for (int i=0; i<testCases; i++) {
			arr[i] = Integer.parseInt(s[i]);
			
			if (arr[i] < MIN) {
				MIN = arr[i];
			}
			
			if (arr[i] > MAX) {
				MAX = arr[i];
			}
		}
		
		System.out.println((MAX+MIN));
	}

}
