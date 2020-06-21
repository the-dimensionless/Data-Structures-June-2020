package code_practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeLeftView {

	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node() {
			data = 0; left=right=null;
		}
		public Node(int d) {
			data = d;
			left = right = null;
		}
	}
	static class BinaryTree {
		Node root;
		
		public BinaryTree() {
			root = new Node();
		}

		 public void insert( int key, Node temp) 
		    { 
		        Queue<Node> q = new LinkedList<Node>(); 
		        q.add(temp); 
		        while (!q.isEmpty()) { 
		            temp = q.peek(); 
		            q.remove(); 
		       
		            if (temp.left == null) { 
		                temp.left = new Node(key); 
		                break; 
		            } else
		                q.add(temp.left); 
		       
		            if (temp.right == null) { 
		                temp.right = new Node(key); 
		                break; 
		            } else
		                q.add(temp.right); 
		        } 
		    } 
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String input[] = kb.nextLine().split(" ");
		int n = input.length;
		System.out.println(Arrays.toString(input));
		
		BinaryTree ob = new BinaryTree();
		ob.root.data = (Integer.parseInt(input[0]));
		for(int i=n-1;i>=0;i--) {
			ob.insert(Integer.parseInt(input[i]), ob.root);
		}
////		System.out.print(ob.root.data+" ");
//		ob.inorder(ob.root);
		
		for(int i=0; i<n;i++) {
			
			if(i == 0 || i%2 !=0) {
				if(Integer.parseInt(input[i]) == -1) {
					break;
				}else {
					System.out.print(Integer.parseInt(input[i])+" ");
				}
			}
		}

	}

}
