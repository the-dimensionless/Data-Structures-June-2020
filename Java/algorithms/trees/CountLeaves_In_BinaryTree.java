package trees;

import java.util.Scanner;

public class CountLeaves_In_BinaryTree {

	static class BinaryTree {
		private Node root;
		
		static class Node {
			int data;
			Node left;	Node right;
			Node (int d) {
				data = d;
				left = null;
				right = null;
			}
		}
	
		private Node buildTreeFromInput (String s) {
			/**
			 * Code to build Tree from given Input
			 */
			
			return null;
		}
		
		public void buildTree(String s) {
			this.root = buildTreeFromInput(s);
		}
		
		private void printInorder (Node root) {
			if (root == null) {
				return;
			}
			
			printInorder (root.left);
			System.out.println(root.data);
			printInorder (root.right);
		}
		
		public void printInorder () {
			printInorder (this.root);
		}
		
		private int height (Node root) {
			if (root == null)
				return 0;
			
			return 1 + Math.max(height (root.left), height (root.right));
		}
		
		public int height () {
			return height(this.root);
		}
		
		private int countLeaves(Node root) {
			if (root == null)
				return 0;
			else if (root.left == null && root.right == null) {
				return 1;
			} else {
				return countLeaves(root.left) + countLeaves(root.right);
			}
		}
		
		public int countLeaves () {
			return countLeaves (this.root);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i<testCases ; i++) {
			String input = sc.nextLine();
			BinaryTree instance = new BinaryTree();
			instance.buildTree(input);
			System.out.println(instance.countLeaves());
		}
		sc.close();

	}

}
