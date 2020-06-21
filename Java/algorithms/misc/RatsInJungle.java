package misc;

import java.util.Scanner;

public class RatsInJungle {

	public static void find(int a[]) {
		int[] assumed = new int[1000];
// assumed max for testing
		int inJungle = 0;

		for (int i = 0; i < a.length; i++) {
			// storing current count by naive try : to modify
			int dictCount = a[i];

			assumed[dictCount] = assumed[dictCount]+1;

			if (assumed[dictCount] == dictCount + 1) {
				// checking
				inJungle = inJungle + assumed[dictCount];
				
				assumed[dictCount] = 0;
			}
		}
		for (int i = 0; i < 1000; i++) {
			if (assumed[i] != 0) {
				inJungle += i + 1;
			}
		}
		System.out.print(inJungle);
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int a[]=new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = kb.nextInt();
		}
		kb.close();
		find(a);
	}

}
