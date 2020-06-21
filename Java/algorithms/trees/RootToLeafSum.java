package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class RootToLeafSum {
	
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
	
	static Scanner kb = new Scanner(System.in);
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

		public void display() {
			this.display(this.root);
		}

		private void display(Node root) {
			if (root.left != null) {
				System.out.print(root.data + "->");
			} else {
				System.out.print("END=>");
			}

			if (root.right != null) {
				System.out.print(root.data + "->");
			} else {
				System.out.print("END=>");
			}

			System.out.println();

			if (root.left != null) {
				this.display(root.left);
			}
			if (root.right != null) {
				this.display(root.right);
			}
		}
		
		public void PathToLeaf(int k) {
			PathToLeaf(new ArrayList<Integer>(), this.root, 0, k);
		}
		private void PathToLeaf(ArrayList<Integer> path, Node node, int sum, int k) {
			if (node == null) {
				return;
			}
			
			if (node.left == null && node.right == null) {
				if (node.data + sum == k) {
					ArrayList<Integer> newAl = new ArrayList<Integer>(path); newAl.add(node.data);
					disp(newAl);
					return ;
				}
			} else if (node.data + sum < k) {
				ArrayList<Integer> newAlleft = new ArrayList<Integer>(path); 
				newAlleft.add(node.data);
				PathToLeaf(newAlleft, node.left, sum+node.data, k);
				ArrayList<Integer> newAlright = new ArrayList<Integer>(path);
				PathToLeaf(newAlright, node.right, sum + node.data, k);
			} else {
				return;
			}
		}
		
		public void disp(ArrayList<Integer> a) {
			for(Integer x : a) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	
}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.PathToLeaf(kb.nextInt());

	}

}
