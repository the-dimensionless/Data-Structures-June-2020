package trees;

import java.util.LinkedList;
import java.util.Scanner;


public class ZigZagBinaryTree {

	static Scanner kb = new Scanner(System.in);
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	static class BinaryTree {
		Node root;
		int size;

		public BinaryTree() {

			this.root = this.takeInput(kb, null, false);
		}

		private Node takeInput(Scanner kb, Node parent, boolean ilc) {
			Node n;
			if (parent == null) {
//				System.out.println("Enter data for root node");
				n = new Node(kb.nextInt());
				this.size++;
			} else {
				if (ilc) {
//					System.out.println("Enter data for left child of " + parent.data);
					n = new Node(kb.nextInt());
					this.size++;
					parent.left = n;
				} else {
//					System.out.println("Enter data for right child of " + parent.data);
					n = new Node(kb.nextInt());
					this.size++;
					parent.right = n;
				}
			}

//			System.out.println("Does " + n.data + " have left child");
			ilc = kb.nextBoolean();
			if (ilc) {
				this.takeInput(kb, n, true);
			}

//			System.out.println("Does " + n.data + " have right child");
			ilc = kb.nextBoolean();
			if (ilc) {
				this.takeInput(kb, n, false);
			}
			return n;
		}

		private void printLevelOrder(Node node) {
			LinkedList<Node> l1 = new LinkedList<Node>();
			l1.addLast(node);
			int counter = 0; LinkedList<Node> l2 = new LinkedList<Node>();

			while (!l1.isEmpty()) {
				Node newNode = l1.removeFirst();
				if (newNode != null) {
					System.out.print(newNode.data + " ");
					if (counter % 2 == 0) { l2.addFirst(newNode.left); 
					l2.addFirst(newNode.right);
					} else {
						l2.addFirst(newNode.right);
						l2.addFirst(newNode.left);
					}
				}
				if (l1.isEmpty()) {
					l1 = l2;
					l2 = new LinkedList<Node>();
					counter = counter + 1;
				}
			}

		}

		public void printLevelOrder() {
			this.printLevelOrder(this.root);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.printLevelOrder();

	}

}
