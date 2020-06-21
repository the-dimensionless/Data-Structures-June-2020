package hackCodeBlocks;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String s = kb.nextLine();
		
		String str[] = s.split("\\.");
		System.out.println(str.length);
		for(int i=0; i<str.length;i++) {
			System.out.println(str[i]);
		}
		
		

	}

}
