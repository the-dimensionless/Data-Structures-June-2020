package binarytree;

import java.util.Scanner;

public class deleteNodesBST {

	static class BST {
	
		
	static class Node {
	      int data;
	      Node left;	      Node right;
	      Node(int x)
	      { 
	    	  this.data = x;
	      }
	  }

	Node root;
	
	public BST() {
		root = null; 
		}
	
	     public void remove(int key) {
	     this.root = remove(this.root,key);
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
	    public Node max(Node node){
	        if(node.right != null){
	            return max(node.right);
	        }
	        return node;
	    }

	   public Node remove(Node root, int key){
	        if(root == null){
	            return root;
	        }

	        if(root.data < key){
	            root.right = remove(root.right, key);
	        }else if(root.data > key){
	            root.left = remove(root.left, key);
	        }else{
	            if(root.left == null){
	                return root.right;
	            }else if(root.right == null){
	                return root.left;
	            }
	            Node temp = max(root.left);
	            root.data = temp.data;
	            root.left = remove(root.left, root.data);
	        }
	        return root;
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

	@SuppressWarnings("unused")
	public static void main(String[] argx) {
		Scanner kb = new Scanner(System.in);
		int test = kb.nextInt();
		for (int i = 0; i < test; i++) {
			int n = kb.nextInt();
			int arr[] = new int[n];
			BST ob = new BST();
			for (int j = 0; j < n; j++) {
				arr[i] = kb.nextInt();
				ob.insert(arr[i]);
			}
			int q = kb.nextInt();
			int queries[] = new int[q];
			for (int j = 0; j < q; j++) {
				arr[j] = kb.nextInt();
				ob.remove(arr[j]);
			}
			ob.PreOrder();
			kb.close();
		}
	}
}

