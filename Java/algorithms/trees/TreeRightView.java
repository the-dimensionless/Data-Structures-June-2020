package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TreeRightView {

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
		int max_level = -1;

		public BinaryTree() {
			root = null;
		}

		public void insert(int x) {
			this.root = insert(x, this.root);
		}

		private Node insert(int x, Node node) { // Level order input
			if (node == null) {
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

		private void TreeRV(Node node, int level) {
			if (node == null)
				return;

			if (this.max_level < level && node.data != -1) {
				System.out.print(node.data + " ");
				this.max_level = level;
			}
			TreeRV(node.right, level + 1);
			TreeRV(node.left, level + 1);

		}

		public void TreeRV() {
			this.TreeRV(this.root, 0);
		}

		private void inorder(Node n) {
			if (n != null) {
				inorder(n.left);
				System.out.print(n.data + " ");
				inorder(n.right);
			}
		}

		public void Inorder() {
			System.out.println();
			this.inorder(this.root);
		}

		@SuppressWarnings("unused")
		private static void printRightView(Node root) {
			if (root == null)
				return;

			Queue<Node> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int n = queue.size();
				for (int i = 1; i <= n; i++) {
					Node temp = queue.poll();
					if (i == n && temp.data != -1)
						System.out.print(temp.data + " ");
					if (temp.left != null)
						queue.add(temp.left);
					if (temp.right != null)
						queue.add(temp.right);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinaryTree bt = new BinaryTree();
		String s[] = br.readLine().split(" ");
		for (int i = 0; i < s.length; i++) {
			bt.insert(Integer.parseInt(s[i]));
		}

		bt.TreeRV();

	}

}
