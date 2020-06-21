package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTopView {

	static class BinaryTree {
		Node root;
		static int maxLevel = -1;

		static class Node {
			int data;
			Node left;
			Node right;

			public Node(int x) {
				this.data = x;
				left = right = null;
			}
		}

		public void levelOrderInput() {
			Scanner kb = new Scanner(System.in);
			String str[] = kb.nextLine().split(" ");
			ArrayList<Integer> al = new ArrayList<Integer>();

			for (int i = 0; i < str.length; i++) {

				if (str[i].trim().equals("")) {
					continue;
				}
				al.add(Integer.parseInt(str[i].trim()));

			}
			int arr[] = new int[al.size()];
			for(int i=0; i<arr.length; i++) {
				arr[i] = al.get(i);
			}
	
			this.root = new Node(arr[0]);

			for (int i = 1; i < arr.length; i++) {
				insertLevelOrder(this.root, arr[i]);
			}

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

		public void topView(Node node, int level) {
			if (node == null)
				return;

			if (node.left != null) {
				showLeftView(node.left, level);
			}
			System.out.print(node.data + " ");
			if (node.right != null) {
				showRightView(node.right, level);
			}
		}

		public boolean showLeftView(Node node, int level) {
			if (node == null || node.data == -1)
				return true;

			boolean val = showLeftView(node.left, level);
			if (val == true) {
				System.out.print(node.data + " ");
				return true;
			}

			return false;
		}

		public boolean showRightView(Node node, int level) {
			if (node == null || node.data == -1)
				return true;

			boolean val = showRightView(node.right, level);
			if (val == true) {
				System.out.print(node.data + " ");
				return true;
			}

			return false;
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.levelOrderInput();
		bt.topView(bt.root, 0);
		
		int i=5; int j=3;
		System.out.println("left shift "+(i<<j));
		System.out.println("right shift"+(i>>j));
	}
}
