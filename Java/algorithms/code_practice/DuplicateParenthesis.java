package code_practice;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateParenthesis {
	
	public static boolean isBal(String s) {
		
		Stack<Character> stack = new Stack<>();
		char ch[] = s.toCharArray();
		
		for(int i=0;i<ch.length;i++) {
			
			if (ch[i] == ')') {
				char tos = stack.peek();
				stack.pop();
				int internals = 0;
				while (tos != '(') {
					internals++;
					tos = stack.peek();
					stack.pop();
				}
				if (internals < 1) {
					return true;
				}
			} else {
				stack.push(ch[i]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String s = kb.nextLine();
		System.out.println(isBal(s));

	}

}
