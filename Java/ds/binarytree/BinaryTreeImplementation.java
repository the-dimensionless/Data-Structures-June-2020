package binarytree;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeImplementation {
	
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
	}
	
	static class BinaryTree {
		Node root;
		int size;
		int max;
		int globalDepth = 0;
		
		public BinaryTree () {
			Scanner kb = new Scanner(System.in);
			this.root = this.takeInput(kb, null, false);
		}
		
		private Node takeInput(Scanner kb, Node parent, boolean ilc) {
			Node n;
			
			if (parent == null) {
				System.out.println("Enter the data for root node");
				n = new Node(kb.nextInt());
				this.size++;
			} else {
				if (ilc) {
					System.out.println("Enter data for left child of " + parent.data);
					n = new Node(kb.nextInt());
					this.size++;
					if (n.data > this.max) {
						this.max = n.data;
					}
					parent.left = n;
				} else {
					System.out.println("Enter data for right child of " + parent.data);
					n = new Node(kb.nextInt());
					this.size++;
					if (n.data > this.max) {
						this.max = n.data;
					}
					parent.right = n;
				}
			}
			
			System.out.println("Does " + n.data + " have left child ?");
			ilc = kb.nextBoolean();
			if (ilc) {
				this.takeInput(kb, n, true);
			}
			
			System.out.println("Does " + n.data + " have right child");
			ilc = kb.nextBoolean();
			if (ilc) {
				this.takeInput(kb, n, false);
			}
			return n;
		}
		
		public void display () {
			this.display(this.root);
		}
		
		private void display(Node root) {
			if (root.left != null) {
				System.out.println(root.data + "->");
			} else {
				System.out.println("END=>");
			}
			
			if (root.right != null) {
				System.out.println(root.data + "->");
			} else {
				System.out.println("END=>");
			}
			
			System.out.println();
			
			if (root.left != null) {
				this.display(root.left);
			}
			if (root.right != null) {
				this.display(root.right);
			}
		}
		
		public void getMax() {
			System.out.println("Maximum element is " + this.max);
		}
		
		public int getHeight() {
			return (int) (Math.log10(this.size) / Math.log10(2));
		}
		
		private void inorder(Node n) {
			if (n != null) {
				inorder(n.left);
				System.out.print(n.data + " ");
				inorder(n.right);
			}
		}

		private void preorder(Node n) {
			if (n == null) {
				return;
			}
			System.out.print(n.data + " ");
			inorder(n.left);
			inorder(n.right);
		}

		private void postorder(Node n) {
			if (n == null) {
				return;
			}
			inorder(n.left);
			inorder(n.right);
			System.out.print(n.data + " ");
		}

		public void Inorder() {
			inorder(this.root);
		}

		public void Postorder() {
			postorder(this.root);
		}

		public void Preorder() {
			preorder(this.root);
		}
		
		public void find (int x) {
			System.out.println("Element at level : " + find(x, this.root));
		}
		
		private int find(int x, Node node) {
			if (node.data == x) {
				return 0;
			} else if (x < node.data) {
				return 1 + find(x, node.left);
			} else if (x > node.data) {
				return 1 + find(x, node.right);
			} else
				return -1;
		}
		
		private int maxFind(Node n) {
			if (n.left == null && n.right == null)
				return n.data;
			else if (n.left != null && n.right != null)
				return Math.max(maxFind(n.left), maxFind(n.right));
			else
				return (n.left == null) ? maxFind(n.right) : maxFind(n.left);
		}
		
		public void maxFind() {
			System.out.println("Max is " + maxFind(this.root));
		}
		
		public void findDiameter() {
			findDiameter(this.root);
		}
		
		private int findDiameter(Node node) {
			/*
			 * if node is null return 0
			 * else find node.left and node.right and add 2
			 * find max between three (left,right, left+right+2)
			 */
			if (node == null)
				return 0;
			else if (node.left != null && node.right != null) {
				int x = findDiameter(node.left) + findDiameter(node.right);
				this.globalDepth = (this.globalDepth >= x) ? this.globalDepth : x;
				return this.globalDepth;
			} else if (node.left == null && node.right == null) {
				return 1;
			} else
				return (node.left == null) ? findDiameter(node.right) + 1 : findDiameter(node.left) + 1;
		}
		
		static class Pair {
			boolean selfdone;
			boolean leftdone;
			boolean rightdone;
			Node node;

			public Pair(Node n) {
				selfdone = false;
				leftdone = false;
				rightdone = false;
				this.node = n;
			}
		}

		public void InorderIterative(Node node) {
			Stack<Pair> st = new Stack<Pair>();
			st.push(new Pair(node));

			while (!st.isEmpty()) {
				Pair p = st.peek();
				System.out.println("in stack "+p.node.data);
				if (p.leftdone == false) {
					if (p.node.left != null) {
						st.push(new Pair(p.node.left)); System.out.println("pushed "+p.node.left.data);
					}
					p.leftdone = true;
				} else if (p.selfdone == false) {
					p.selfdone = true;
					System.out.print(p.node.data + " ");
				} else if (p.rightdone == false) {
					if (p.node.right != null) {
						st.push(new Pair(p.node.right));
					}
					st.push(new Pair(p.node.right));
				} else {
					st.pop();
				}
			}
		}

		public void InorderIterative() {
			InorderIterative(this.root);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		System.out.println("Size is (No of elements) " + bt.size);
		System.out.println("Height is " + bt.getHeight());
		System.out.println("Maximum element is " + bt.max);
		System.out.println("Inorder traversal is ");
		bt.Inorder();
		System.out.println();
		System.out.println("Preorder traversal is \n");
		System.out.println();
		bt.Preorder();
		System.out.println();
		System.out.println("Postorder traversal is \n");
		System.out.println();
		bt.Postorder();
		System.out.println();
		bt.maxFind();
		/*bt.find(3);*/
		bt.findDiameter();
		System.out.println("global depth is (diameter) " + bt.globalDepth);
//		bt.InorderIterative();
	}

}
