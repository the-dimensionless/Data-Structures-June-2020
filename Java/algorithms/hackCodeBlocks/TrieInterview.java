package hackCodeBlocks;

import java.util.Scanner;

public class TrieInterview {

	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		int n =kb.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		int sum = 0;
		for(int i=0;i<n;i+=2) {
			sum += arr[i]^arr[i+1];
		}
		System.out.println(sum);

	}

}
