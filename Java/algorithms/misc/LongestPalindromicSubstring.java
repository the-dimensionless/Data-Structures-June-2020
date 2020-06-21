package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubstring {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			String ans = br.readLine();
			findLPS(ans);
		}
	}

	static void display(String s, int i, int j) {
		System.out.println(s.substring(i, j + 1));
	}

	public static void findLPS(String s) { 
		int maxLength = 1; 

		int start = 0; 
		int len = s.length(); 

		int low, high; 

		for (int i = 1; i < len; ++i) 
		{ 
			low = i - 1; 
			high = i; 
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) { 
				if (high - low + 1 > maxLength) { 
					start = low; 
					maxLength = high - low + 1; 
				} 
				--low; 
				++high; 
			} 

			low = i - 1; 
			high = i + 1; 
			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) { 
				if (high - low + 1 > maxLength) { 
					start = low; 
					maxLength = high - low + 1; 
				} 
				--low; ++high; 
			} 
		} 
		display(s, start, start + maxLength - 1); 
	} 
} 
