package code_practice;

import java.util.Scanner;

public class Jumping {

	public static int findMinRec(int a[], int steps, int index) {
		
		if(index >= a.length) {
			return steps-1;
		}
		if (index == 0) {
			int index2 = index + a[index] ;
			System.out.println("jumping from index "+index+" to "+index2);
			System.out.println("Element here is "+a[index]);
			return findMinRec(a, steps+1, index2);
		} else {
			int index2 = index + a[index] - 1;
			System.out.println("jumping from index "+index+" to "+index2);
			System.out.println("Element here is "+a[index]);
			return findMinRec(a, steps+1, index2);
		}
		
		
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int N = kb.nextInt();
		int a[] = new int[N];
		for(int i=0;i<N;i++) {
			a[i] = kb.nextInt();
		}
		System.out.println(findMinRec(a,0,0));
	}

	
}
