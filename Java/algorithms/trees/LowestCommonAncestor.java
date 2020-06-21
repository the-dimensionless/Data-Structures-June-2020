package trees;

import java.util.Scanner;

public class LowestCommonAncestor {

	static class Node {
		int data; Node left; Node right;
		public Node(int d) {
			data = d; left = right = null;
		}
	}
	
	static class BST {
		Node root;
		int size;
		int maximum;
		int minimum;
		
		public BST () {
			root = null;
		}
		
		public void insert(int x) {
			this.root = insert(x, root); this.size++;
		}
		
		private Node insert(int x, Node node) {
			if(node == null) {
				node = new Node(x);
			}
			if ( x < node.data) {
				node.left = insert(x, node.left);
			} else if (x > node.data) {
				node.right = insert(x, node.right);
			}
			return node;
		}
		
		public void remove(int x) {
			this.root = remove( x, this.root);
		}
		private Node remove(int x, Node node) {
			if (node == null) {
				return null;
			}
			if (x < node.data) {
				node.left = remove(x, node.left);
			} else if (x > node.data) {
				node.right = remove(x, node.right);
			} else if (node.left != null && node.right != null) {
				// this node has two children
				node.data = findMin(node.right).data; 
				node.right = removeMin(node.right);
			} else {
				node = (node.left == null )? node.right : node.left;
			}
			return node;
		}
		
		private Node findMin(Node node) {
			if(node!=null) {
				while(node.left!=null) {
					node = node.left;
				}
			}
			return node;
		}
		
		private Node findMax(Node node) {
			if(node!=null) {
				while(node.right!=null)
					node = node.right;
			}
			return node;
		}
		
		public void findMin() {
			System.out.println("Minimum node is "+findMin(this.root).data);
		}
		public void findMax() {
			System.out.println("Maximum node is "+findMax(this.root).data);
		}
		
		private Node removeMin(Node node) {
			if(root == null)
				;
			else if(node.left!=null) {
				  node.left = removeMin(node.left);
				  return node;
			}
			return node.right;
		}
		
		public void PreOrder() {
			printPreorder(this.root);
		}
		private void printPreorder(Node node) {
			if (node == null) {
				return;
			}
			System.out.print(node.data+" ");
			printPreorder(node.left);
			printPreorder(node.right);
		}
		private void printInorder(Node node) {
			if (node == null) {
				return;
			}
			printPreorder(node.left); System.out.print(node.data+" ");
			printPreorder(node.right);
		}
		public void InOrder() {
			printInorder(this.root);
		}
	
		boolean isBST(Node node, int min, int max) {
			if (node == null)
				return true;
			if (node.data < min || node.data > max)
				return false;
			return (isBST(node.left, min, node.data - 1) && isBST(node.right, node.data + 1, max));
		}
		
		public void isBST() {
			System.out.println("is BST ? "+isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		}
		
		private Node lowestCommonAncestor(Node node, int c1, int c2) {
			
			if (node == null)
				return null;
			if (node.left!=null && node.right!=null && node.left.data == c1 && node.right.data == c2) {
					return node;
			}
			if (c1 < node.data && c2 < node.data) {
				return lowestCommonAncestor(node.left, c1, c2);
			} else if (c1 > node.data && c2 > node.data) {
				return lowestCommonAncestor(node.right, c1, c2);
			}
			return node;
		}
		public int lowestCommonAncestor(int c1, int c2) {
			return lowestCommonAncestor(this.root, c1, c2).data;
		}
	}

	
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		BST ob = new BST();
		for(int i=0;i<n;i++) {
			ob.insert(kb.nextInt());
		}
		int c1 = kb.nextInt(); int c2 = kb.nextInt();
		System.out.println(ob.lowestCommonAncestor(c1, c2));
		kb.close();
	}

}
