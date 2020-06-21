package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LargestBST {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int x) {
			this.data = x;
			this.left = this.right = null;
		}
	}

	static class BinaryTree {
		Node root;
		Node seek;
		public BinaryTree() {
			root = null;
		}
		
		public void findLargest() {
			System.out.println("Size of largest bst is "+(this.findLargest(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE)-1));
		}
		public int findLargest(Node node, int min, int max) {
			if(node == null || node.data== -1)
				return 0;
			if (isBST(node, min, max)) {
				System.out.println("this is bst : "+node.data);
				return size(node);
			}	
			else {
				return Math.max(findLargest(node.left, min, node.data), findLargest(node.right,  node.data, max) );
				}
			}
		int size(Node n1) {
			if(n1 == null || n1.data== -1)
				return 0;
			else return 1 + size(n1.left) + size(n1.right);
		}
		boolean isBST(Node node, int min, int max) {
			if (node == null)
				return true;
			if(node.data == -1)
				return false;
			if (node.data < min || node.data > max)
				return false;
			return (isBST(node.left, min, node.data - 1) && isBST(node.right, node.data + 1, max));
		}

		public void insert(int x) {
			this.root = insert(x, this.root);
		}

		private Node insert(int x, Node node) { // Level order input
			if(node == null) {
				node = new Node(x);
				return node;
			}
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			Node head = node;

			while (!q.isEmpty()) {
				node = q.peek();
				q.remove();

				if (node.left == null) {
					node.left = new Node(x);
					break;
				} else {
					q.add(node.left);
				}

				if (node.right == null) {
					node.right = new Node(x);
					break;
				} else {
					q.add(node.right);
				}
			}
			return head;
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		BinaryTree bt = new BinaryTree();
		int t = kb.nextInt();
		for (int i = 0; i < t; i++) {
			bt.insert(kb.nextInt());
		}
//		System.out.println(bt.findLargest(bt.root));
		bt.findLargest();
		kb.close();
	}
}
