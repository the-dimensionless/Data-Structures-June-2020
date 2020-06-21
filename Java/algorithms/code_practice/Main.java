package code_practice;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.next();
		Main mainobj = new Main();
		StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000);
		if (isBalanced(str, stack)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static boolean isBalanced(String str, StacksUsingArrays stack) throws Exception {
		char ch[] = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
				int indie = (int) ch[i];

				stack.push(indie);
			} else if (ch[i] == ')' || ch[i] == '}' || ch[i] == ']') {

				if (stack.isEmpty()) {
					return false;
				} else {
					char tos = (char) stack.top();
					if ((tos == '(' && ch[i] == ')') || (tos == '{' && ch[i] == '}') || (tos == '[' && ch[i] == ']')) {
						stack.pop();
					} else {
						return false;
					}
				}

			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	private class StacksUsingArrays {
		private int[] data;
		private int tos;

		public static final int DEFAULT_CAPACITY = 10;

		public StacksUsingArrays() throws Exception {
			// TODO Auto-generated constructor stub
			this(DEFAULT_CAPACITY);
		}

		public StacksUsingArrays(int capacity) throws Exception {
			if (capacity <= 0) {
				System.out.println("Invalid Capacity");
			}
			this.data = new int[capacity];
			this.tos = -1;
		}

		public int size() {
			return this.tos + 1;
		}

		public boolean isEmpty() {
			if (this.size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		public void push(int item) throws Exception {
			if (this.size() == this.data.length) {
				throw new Exception("Stack is Full");
			}
			this.tos++;
			this.data[this.tos] = item;
		}

		public int pop() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			this.data[this.tos] = 0;
			this.tos--;
			return retVal;
		}

		public int top() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			return retVal;
		}

		public void display() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			for (int i = this.tos; i >= 0; i--) {
				System.out.println(this.data[i]);
			}

		}

	}

//
//	public static boolean isBal(String s) {
//
//		Stack<Character> stack = new Stack<>();
//		char ch[] = s.toCharArray();
//
//		for (int i = 0; i < ch.length; i++) {
//
//			if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
//				stack.push(ch[i]);
//			} else if (ch[i] == ')' || ch[i] == '}' || ch[i] == ']') {
//
//				char tos = stack.peek();
//				if ((tos == '(' && ch[i] == ')') || (tos == '{' && ch[i] == '}') || (tos == '[' && ch[i] == ']')) {
//					stack.pop();
//				} else {
//					return false;
//				}
//
//			}
//		}
//		return true;
//	}
//
//	public static void main(String[] args) {
//		Scanner kb = new Scanner(System.in);
//		String s = kb.nextLine();
//		if(isBal(s)) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		};
//
//	}

}
