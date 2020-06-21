package code_practice;

import java.util.Scanner;

public class Celebrity {

	public static boolean findIfCelebrityExists(int a[][], int j) {
		int sumOfCelebrity = 0;
		for(int i = 0; i<a.length; i++) {
			sumOfCelebrity += a[j][i];
		}
		if(sumOfCelebrity==0) 
			return true;
		else return false;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int arr[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = kb.nextInt();
			}
		}
		
		int s[] = new int[N];
		boolean isCelebrity = false;
		int c= 0;
		int index = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1 && arr[j][i] != 1) {
					System.out.println("It is possible that "+j+" is celeb");
					isCelebrity = findIfCelebrityExists(arr, j); 
					if(isCelebrity == true) {
						index = j; c = 1; break;
					}
						
				}
			}
		}
		
		if(c == 1) {
			System.out.println(index);
		} else {
			System.out.println("No Celebrity");
		}

	}

}
