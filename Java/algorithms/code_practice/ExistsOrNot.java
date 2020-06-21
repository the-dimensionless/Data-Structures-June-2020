package code_practice;

import java.util.Scanner;

public class ExistsOrNot {

	public static void OrNot(int a[], int x) {
		
		for(int i=0;i<a.length;i++) {
			if(x == a[i]) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int t = kb.nextInt();
		for(int i=0;i<t;i++) {
			int l = kb.nextInt();
			int arr[] = new int[l];
			for(int j=0;j<l;j++) {
				arr[j]=kb.nextInt();
			}
			int q = kb.nextInt();
			for(int j = 0;j<q;j++) {
				OrNot(arr, kb.nextInt());
			}
			
		}

	}

}
