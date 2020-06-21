package bitMagic;

import java.util.Scanner;

public class RightMostDifferentBit {

	public static void main(String[] args) {
		
//		int a  =11;
//		int b  =9;
//		System.out.println(Integer.toBinaryString(a));
//		System.out.println(Integer.toBinaryString(b));
//		System.out.println(Integer.toBinaryString((a ^ b)));
//		System.out.println((int)((Math.log10(a ^b)) / Math.log10(2)) + 1);
		
		
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		
		for(int i=0; i<t ; i++) {
		    int m = kb.nextInt();
		    int n = kb.nextInt();
		    System.out.println((int)((Math.log10(m ^ n)) / Math.log10(2)) + 1);
		}
		kb.close();

	}

}
