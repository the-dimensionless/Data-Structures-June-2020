package hackCodeBlocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class FormBiggestNumber {
//
//	static class Number implements Comparable<Number> {
//		int x;
//		public Number(int x) {
//			this.x = x;
//		}
//		
//		public int compareTo(Number o2) {
//			String newNosOne = this.x + "" + o2.x;
//			int number1 = Integer.valueOf(newNosOne);
//			String newNosTwo = o2.x + "" + this.x;
//			int number2 = Integer.valueOf(newNosTwo);
//			if (number1 > number2)
//				return -1;
//			else
//				return 1;
//		}
//	}
//	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int test = kb.nextInt();
		for (int k = 0; k < test; k++) {
			int n = kb.nextInt();
			Vector<String> arr = new Vector<String>(n);
			for (int i = 0; i < n; i++) {
				arr.add(String.valueOf(kb.nextInt()));
			}
			sort(arr);
		}

	}

	static void sort(Vector<String> arr) {
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String X, String Y) {
				String XY = X + Y;
				String YX = Y + X;
				int ans = XY.compareTo(YX);
				if (ans > 0) {
					return -1;
				} else
					return 1;
			}
		});
		Iterator it = arr.iterator();  
	    while(it.hasNext()) 
	        System.out.print(it.next()); 
	    
	    System.out.println();
	      
	    } 


}
