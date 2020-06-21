package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MajorityElementInAnArray {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int freq = 0; int max = 0;
		int testCases = Integer.parseInt(br.readLine());
		int arr[] = new int[testCases];
		
		String s[] = br.readLine().split(" ");
		for (int i=0; i<testCases; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(arr);
		
		
		int t = arr[0]; int flag = 0;
		
		int element = 0;
		
		for (int i=0; i<testCases; i++) {
			if (t == arr[i]) {
				freq++;
			} else {
				freq = 1;
				t = arr[i];
			}
			
			if (max < freq) {
				max = freq;
				
				element = arr[i];
				
				if (max > ( testCases / 2 ) ) {
					flag = 1;
					break;
				}
			}
		}
		
		if (flag == 1) {
			System.out.println(element);
		} else {
			System.out.println(-1);
		}
	}

}
