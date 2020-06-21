package hackCodeBlocks;

import java.util.*;

public class StructurallyIdenticalTrees {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		StructurallyIdenticalTrees m = new StructurallyIdenticalTrees();
		BinaryTree bt1 = m.new BinaryTree();
		BinaryTree bt2 = m.new BinaryTree();
		System.out.println(bt1.structurallyIdentical(bt2));
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public boolean structurallyIdentical(BinaryTree other) {
			return this.structurallyIdentical(this.root, other.root);
		}

		private boolean structurallyIdentical(Node tnode, Node onode) {
			System.out.println("current node " + tnode.data + " and " + onode.data);
			if (tnode.data != onode.data) {
				return false;
			} else if (tnode.left == null && tnode.right == null && onode.left == null && onode.right == null) {
				System.out.println("end of line for both");
				return true;
			} else if (tnode.left == null && onode.left == null && tnode.right != null && onode.right != null) {
				System.out.println("both go towards right");
				return true && structurallyIdentical(tnode.right, onode.right);
			} else if (tnode.right == null && onode.right == null && tnode.left != null && onode.left != null) {
				System.out.println("both go towards left");
				return true && structurallyIdentical(tnode.left, onode.left);
			} else if (tnode.left != null && tnode.right != null && onode.left != null && onode.right != null) {
				return structurallyIdentical(tnode.left, onode.left) && structurallyIdentical(tnode.right, onode.right);
			} else {
				return false;
			}
		}

	}
}
