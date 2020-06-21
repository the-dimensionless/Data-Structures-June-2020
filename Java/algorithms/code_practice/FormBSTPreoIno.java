package code_practice;

import java.util.Scanner;

public class FormBSTPreoIno {

	static class Node {
		int data;
		Node left, right;

		public Node(int d) {
			data = d;
			left = right = null;
		}
	}
	
	static class BinaryTree {
		Node root;
		public BinaryTree() {
			root = null;
		}
		private Node buildTree(int[] preorder, int i, int[] inorder, int j, int pindex) {

			if (i > j)
				return null;

			Node node = new Node(preorder[pindex]);
			pindex++;

			if (i == j) {
				return node; // let's assume this is last element
			}

			int iIndex = findIndexInorder(inorder, i, j, node.data);
			node.left = buildTree(preorder, i, inorder, iIndex - 1, j);
			node.right = buildTree(preorder, i, inorder, iIndex + 1, j);

			return node;
		}

		private int findIndexInorder(int arr[], int start, int end, int d) {
			int i;

			for (i = start; i <= end; i++) {
				if (arr[i] == d) {
					return i;
				}
			}
			return i;
		}
	
		public void buildTree(int []preorder, int[] inorder) {
			this.root = buildTree(preorder, 0, inorder, 0, 0);
		}
		
		public void Inorder(Node node) {
			if(node == null)
				return;
			
			Inorder(node.left);
			System.out.print(node.data+" ");
			Inorder(node.right);
		}
	}


	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String s[] = kb.nextLine().split(" ");
		int preorder[] = new int[s.length];
		for (int i = 0; i < preorder.length; i++) {
			preorder[i] = kb.nextInt();
		}

		s = kb.nextLine().split(" ");
		int inorder[] = new int[s.length];
		for (int i = 0; i < inorder.length; i++) {
			inorder[i] = kb.nextInt();
		}
		BinaryTree bt = new BinaryTree();
		bt.buildTree(preorder, inorder);
		bt.Inorder(bt.root);

	}

}