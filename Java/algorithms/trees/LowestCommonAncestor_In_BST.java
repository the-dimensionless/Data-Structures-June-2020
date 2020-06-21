package trees;

/**
 * Given a Binary Search Tree of size N and 2 nodes value n1 and n2, 
 * your task is to find the lowest common ancestor(LCA) of the two nodes .
 * Note: Duplicates are not inserted in the BST.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LowestCommonAncestor_In_BST {

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
		
		private Node LCA (Node node, int c1, int c2) {
			if (node == null)
				return null;
			if (node.left!=null && node.right!=null && node.left.data == c1 && node.right.data == c2) {
					return node;
			}
			if (c1 < node.data && c2 < node.data) {
				return LCA (node.left, c1, c2);
			} else if (c1 > node.data && c2 > node.data) {
				return LCA (node.right, c1, c2);
			}
			return node;
		}
		
		public int LCA (int d1, int d2) {
			return LCA (this.root, d1, d2).data;
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
