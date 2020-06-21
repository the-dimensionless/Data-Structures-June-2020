package code_practice;

import java.util.Scanner;
public class RootToLeaf {
	
	static class Node {
		int data; Node left; Node right;
		public Node(int d) {
			data = d; left = right = null;
		}
		public Node(int d, Node l, Node r) {
			data = d; left = l; right = r;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
	}
	
	static class BinaryTree {
		Node root;
		int size;
		int max;
		
		public BinaryTree() {
			Scanner kb = new Scanner(System.in);
			String s[] = kb.nextLine().split(" ");
			this.root = this.takeInput(s, 0,null, false);
		}
		
		private Node takeInput(String[] s,int index, Node parent, boolean ilc) {
			Node n;
			if(parent == null) {
				System.out.println("Enter data for root node");
				n = new Node(Integer.parseInt(s[index])); this.size++; index++;
			} else {
				if (ilc) {
					System.out.println("Enter data for left child of "+parent.data);
					n = new Node(Integer.parseInt(s[index]));
					this.size++; index++;
					if(n.data > this.max) {
						this.max = n.data;
					}
					parent.left = n;
				} else {
					System.out.println("Enter data for right child of "+parent.data);
					n = new Node(Integer.parseInt(s[index]));
					this.size++; index++;
					if(n.data > this.max) {
						this.max = n.data;
					}
					parent.right = n;
				}
			}
			
			System.out.println("Does "+n.data+" have left child");
			ilc = Boolean.getBoolean(s[index]); index++;
			if(ilc) {
				this.takeInput(s, index ,n, true);
			}
			
			System.out.println("Does "+n.data+" have right child");
			ilc = Boolean.getBoolean(s[index]); index++;
			if(ilc) {
				this.takeInput(s, index, n, false);
			}
			return n;
		}
		
		public void display() {
			this.display(this.root);
		}
		private void display(Node root) {
			if(root.left!=null) {
				System.out.print(root.data+"->");
			} else {
				System.out.print("END=>");
			}
			
			if(root.right!=null) {
				System.out.print(root.data+"->");
			} else {
				System.out.print("END=>");
			}
			
			System.out.println();
			
			if(root.left!=null) {
				this.display(root.left);
			}
			if(root.right!=null) {
				this.display(root.right);
			}
		}
		public void getMax() {
			System.out.println("Maximum Element is "+this.max);
		}
		public int getHeight() {
			return (int) (Math.log10(this.size)/Math.log10(2));
		}
		
		private void inorder(Node n) {
			if(n!=null) {
				inorder(n.left);
				System.out.print(n.data+" ");
				inorder(n.right);
			}
		}
		private void preorder(Node n) {
			if(n==null) {
				return;
			}
			System.out.print(n.data+" ");
			inorder(n.left);
			inorder(n.right);
		}
		private void postorder(Node n) {
			if(n==null) {
				return;
			}
			inorder(n.left);
			inorder(n.right);
			System.out.print(n.data+" ");
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
		public void find(int x) {
			System.out.println("Element at level : "+find(x, this.root));
		}
		private int find(int x, Node node) {
			
			if(node.data == x)
				return 0;
			else if (x < node.data)
				return 1+find(x, node.left);
			else if(x > node.data)
				return 1+find(x, node.right);
			else
				return -1;
		}

		private int maxFind(Node n) {
			if(n.left == null && n.right == null)
				return n.data;
			else if(n.left!=null && n.right!=null)
				return Math.max(maxFind(n.left), maxFind(n.right) );
			else
				return (n.left == null )? maxFind(n.right) : maxFind(n.left);
		}
		public void maxFind() {
			System.out.println("Max is "+maxFind(this.root));
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.Inorder();

	}

}
