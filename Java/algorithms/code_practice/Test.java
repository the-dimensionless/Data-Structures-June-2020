package code_practice;

import java.util.Scanner;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();
		
		st.push(1);
		st.push(2);
		st.push(3);
		
		System.out.println(st);
		System.out.println(st.peek());
		

	}

}
