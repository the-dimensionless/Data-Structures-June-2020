package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeLeftView {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int d) {
			data = d;
			left = right = null;
		}

		public Node(int d, Node l, Node r) {
			data = d;
			left = l;
			right = r;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}

	static class BinaryTree {
		Node root;
		int size;

		public BinaryTree() {
		}

//		private void TreeLV(Node node, int level) { // Wrong Answer
//			if (node == null)
//				return;
//			if (level == 0) {
//				System.out.print(node.data+" ");
//				TreeLV(node.left, level + 1); TreeLV(node.right, level + 1);
//			} else {
//				if (level > globalLevel ) {
//					globalLevel = level;
//					if(node.data!= -1) {
//						System.out.print(node.data+" ");
//					}
//					TreeLV(node.left, level + 1); TreeLV(node.right, level + 1);
//				}
//			}
//		}

		private void TreeLV(Node node, int level, int uLevel[]) {
			if (node == null)
				return;
//			System.out.println("current node "+node.data+" and level is "+level);
			if (level > uLevel[0] && node.data != -1) {
				uLevel[0] = level;
				System.out.print(node.data + " ");
			}

			TreeLV(node.left, level + 1, uLevel);
			TreeLV(node.right, level + 1, uLevel);
		}

		public void TreeLV() {
			int[] uLevel = new int[1];
			uLevel[0] = -1;
			this.TreeLV(this.root, 0, uLevel);
		}

		public void Inorder(Node n) {
			if (n == null)
				return;
			Inorder(n.left);
			System.out.print(n.data + " ");
			Inorder(n.right);
		}

		void insertLevelOrder(Node temp, int key) {
			if (temp == null) {
				this.root = new Node(key);
				return;
			}
			Queue<Node> q = new LinkedList<Node>();
			q.add(temp);
			while (!q.isEmpty()) {
				temp = q.peek();
				q.remove();

				if (temp.left == null) {
					temp.left = new Node(key);
					break;
				} else
					q.add(temp.left);

				if (temp.right == null) {
					temp.right = new Node(key);
					break;
				} else
					q.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String s[] = kb.nextLine().split(" ");
		BinaryTree bt = new BinaryTree();
		for (String x : s) {
			bt.insertLevelOrder(bt.root, Integer.parseInt(x));
		}
//		bt.display();
//		bt.Inorder(bt.root);
//		System.out.println();
		bt.TreeLV();
		kb.close();

	}

}
