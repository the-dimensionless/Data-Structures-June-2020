package hackCodeBlocks;

import java.util.Scanner;
public class DeleteNodesInBST {
	
	static class Node {
		int data; Node left; Node right;
		public Node(int d) {
			data = d; left = right = null;
		}
	}
	
	static class BST {
		Node root;
		int maximum;
		int minimum;
		
		public BST () {
			root = null;
		}
		public void insert(int x) {
			this.root = insert(x, root);
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
	}

	public static void main(String []argx) {
		Scanner kb = new Scanner(System.in);
		int test = kb.nextInt();
		for(int i=0;i<test;i++) {
			int n = kb.nextInt();
			int arr[] = new int[n];
			BST ob = new BST();
			for(int j=0;j<n;j++) {
				arr[i] = kb.nextInt();
				ob.insert(arr[i]);
			}
			int q = kb.nextInt();
			int queries[] = new int[q];
			for(int j=0; j<q;j++) {
				arr[j] = kb.nextInt();
				ob.remove(arr[j]);
			}
			ob.PreOrder();
			System.out.println("Done");
		}
	}
}
