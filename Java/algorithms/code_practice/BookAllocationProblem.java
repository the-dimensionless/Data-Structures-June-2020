package code_practice;

import java.util.Scanner;

public class BookAllocationProblem {

	public static void findMinAllocation(int pages[], int index, int sum, int left_sum, int students) {
		
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		
		int books = kb.nextInt();
		int students = kb.nextInt();
		
		int pages[] = new int[books];
		for(int i=0;i<books;i++) {
			pages[i] = kb.nextInt();
		}
		
		for(int i = books-1; i>=0; i--) {
			
		}
		
//		findMinAllocation(pages, 0, sum, left_sum, students);

	}

}
