package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Height_Of_BinaryTree {
	
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
			
			if (s.length() == 0 || s.charAt(0) == 'N') {
				return null;
			}
			
			String input[] = s.split(" ");
			
			// We create the root
			Node root = new Node(Integer.parseInt(input[0]));
			
			// We push the root onto a queue
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			
			int i = 1;
			
			while (q.size() > 0 && i < input.length) {
				// We retrieve and remove the front of queue
				Node currentNode = q.poll();
				
				// We store the currentNode value
				String currentValue = input[i];
				
				// For left child
				if (!currentValue.equals("N")) {
					currentNode.left = new Node(Integer.parseInt(currentValue));
					q.add(currentNode.left);
				}
				
				// For right child
				i++;
				
				if (i >= input.length) {
					break;
				}
				
				// We store the currentNode value
				currentValue = input[i];
				
				if (!currentValue.equals("N")) {
					currentNode.right = new Node(Integer.parseInt(currentValue));
					q.add(currentNode.right);
				}
				
				i++;
			}
			
			return root;
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
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i<testCases ; i++) {
			String input = sc.nextLine();
			BinaryTree instance = new BinaryTree();
			instance.buildTree(input);
			System.out.println(instance.height());
		}
		sc.close();
	}

}
