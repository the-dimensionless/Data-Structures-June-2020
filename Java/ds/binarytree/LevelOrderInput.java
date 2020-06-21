package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderInput {
	static class Node {
		int value;
		Node left, right;

		public Node(int d) {
			this.value = d;
			left = right = null;
		}
	}

	static class BTree {
		Node root;
		int size;
		static int firstSeenLevel = -1;

		public BTree() {
			this.root = null;
		}

		private void printLeftView(Node node, int level) {
			if (node == null) {
				return;
			}
			if (firstSeenLevel > level && node.value != -1) {
				firstSeenLevel = level;
				System.out.print(node.value + " ");
			}

			printLeftView(node.left, level + 1);
			printLeftView(node.right, level + 1);
		}

		public void insert(Integer arr[]) {
			Queue<Node> queue = new LinkedList<Node>();
			int i = 0;
			int len = arr.length;
			if (this.root == null) {
				this.root = new Node(arr[0]);
				queue.add(this.root);
			}
			for (i = 1; i < len - 1; i++) {
				Node current = queue.poll();
				if (arr[i] != -1) {
					current.left = new Node(arr[i]);
					queue.add(current.left);
				}
				i++;
				if (arr[i] != -1) {
					current.right = new Node(arr[i]);
					queue.add(current.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String s[] = kb.nextLine().split(" ");
		Integer a[] = new Integer[s.length];
		BTree obj = new BTree();
		for (int i = 0; i < s.length; i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		obj.insert(a);
		obj.printLeftView(obj.root, 0);
		kb.close();
	}
}
