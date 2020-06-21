package binarytree;

public class BSTImplementation {

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
	}

	
	public static void main(String[] args) {
		BST ob = new BST();
		ob.insert(50); ob.insert(25); ob.insert(75); ob.insert(12); ob.insert(37); ob.insert(62); ob.insert(87);
		ob.findMax(); ob.findMin();
		ob.InOrder(); 
		System.out.println();
		ob.isBST();
		
		ob.remove(37); System.out.println("On removing 37");
		ob.InOrder();
		ob.remove(50); System.out.println("On removing 50");
		ob.InOrder();

	}

}
