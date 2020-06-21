package hackCodeBlocks;

import java.util.ArrayList;
import java.util.Scanner;

public class StockSpan {

	public static void findSpan(Integer arr[], int len) {
		
		int storage[] = new int[len];
		
		for(int i=0;i<len;i++) {
			storage[i] = 0;
		}
		
		for(int i=0;i<len;i++) {
			storage[i] = 1;
			for(int j=i-1;j>=0;j--) {
				if (arr[j]<=arr[i]) {
					storage[i]++;
				} else {
					break;
				}
			}
		}
		
		for(int i=0;i<len;i++) {
			System.out.print(storage[i]+" ");
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		ArrayList<Integer[]> al = new ArrayList<Integer[]>();
		for(int i=0; i<t;i++) {
			int n = kb.nextInt();
			Integer arr[] = new Integer[n];
			for(int j=0;j<n;j++) {
				arr[j] = kb.nextInt();
			}
			al.add(arr);
		}
		
		for(Integer[] i : al) {
			findSpan(i, i.length);
		}

	}

}
