package bitMagic;

import java.util.Scanner;

/*
 * Given an integer an N. 
 * The task is to print the position of first set bit found from right side in the binary representation of the number.
 */
public class FindFirstSetBit {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		for (int i=0; i<t ; i++) {
			int N = kb.nextInt();
			String binary = Integer.toBinaryString(N);
//			System.out.println(binary);
			int length = binary.length();
			int li = binary.lastIndexOf('1');
			int result = length-li;
			
			if (li == -1) {
				System.out.println(0);
			} else {
				System.out.println(result);
			}
			
			test(N);
		}
		
		kb.close();

	}
	
	// Check bitwise methods
	public static int getFirstSetBitPos(int n) 
    { 
        return (int)((Math.log10(n & -n)) / Math.log10(2)) + 1; 
    } 
	
	static void test(int n) {
		System.out.println();
		System.out.println("Number is "+n+" and binary is "+Integer.toBinaryString(n));
		System.out.println("Number is "+(-n)+" and binary is "+Integer.toBinaryString(-n));
		System.out.println( (n & -n) + " and binary is "+Integer.toBinaryString((n&(-n))));
		System.out.println((Math.log10(n & -n)));
		System.out.println((int)((Math.log10(n & -n)) / Math.log10(2)));
		System.out.println((int)((Math.log10(n & -n)) / Math.log10(2)) + 1);
	}

}
