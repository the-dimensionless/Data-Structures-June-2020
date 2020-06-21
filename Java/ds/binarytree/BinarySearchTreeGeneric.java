package binarytree;

import java.util.Scanner;

class Node<E> {
	E data;
	Node<E> left;
	Node<E> right;
	
	Node(E node) {
		data = node;
		left = null;
		right = null;
	}
}
public class BinarySearchTreeGeneric<E extends Comparable<? super E>> {

	protected Node<E> root;
	public BinarySearchTreeGeneric() {
		root = null;
	}
	
	boolean isEmpty() {
		return root == null;
	}
	void makeEmpty() {
		root = null;
	}
	
	private E elementAt(Node<E> t) {
		return t == null ? null : t.data;
	}
	protected Node<E> findMin(Node<E> root) {
		if (root != null) {
			while(root.left != null)
				root = root.left;
		}
		return root;
	}
	
	public E findMin() {
		return elementAt(findMin(root));
	}
	
	protected Node<E> findMax(Node<E> root) {
		if (root != null) {
			while (root.right != null)
				root = root.right;
		}
		return root;
	}
	
	E findMax() {
		return elementAt(findMax(root));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Node<E> insert(E x, Node<E> node) throws DuplicateItemException {
		
		if (node == null)
			node = new Node(x);
		else if(x.compareTo(node.data) < 0)
			node.left = insert(x, node.left);
		else if(x.compareTo(node.data) > 0)
			node.right = insert(x, node.right);
		else
			throw new DuplicateItemException(x.toString());
		return node;
	}
	void insert(E x) throws DuplicateItemException {
		this.root = insert(x, this.root);
	}
	
	protected Node<E> removeMin(Node<E> root) throws ItemNotFoundException {
		if (root == null)
			throw new ItemNotFoundException();
		else if(root.left !=  null) {
			root.left = removeMin(root.left);
			return root;
		}
		return root.right;
	}
	
	public void removeMin() throws ItemNotFoundException {
		root = removeMin(this.root);
	}
	
	protected Node<E> remove(E x, Node<E> root) throws ItemNotFoundException {
		if (root == null)
			throw new ItemNotFoundException();
		if (x.compareTo(root.data) < 0)
			root.left = remove(x, root.left);
		else if (x.compareTo(root.data) > 0)
			root.right = remove(x, root.right);
		else if (root.left != null && root.right != null) {
			root.data = findMin(root.right).data; 
			root.right = removeMin(root.right);
		} else
			root = (root.left != null) ? root.left:root.right;
		return root;
	}
	
	void remove(E x) throws ItemNotFoundException {
		root = remove(x, root);
	}
	void PreOrder() {
		PreOrder(this.root);
	}
	protected void PreOrder(Node<E> node) {
		if(node!=null) {
			System.out.print(node.data+" ");
			PreOrder(node.left);
			PreOrder(node.right);
			
		}
		return;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws DuplicateItemException, ItemNotFoundException {
		Scanner kb = new Scanner(System.in);
		int test = kb.nextInt();
		for(int i=0;i<test;i++) {
			int n = kb.nextInt();
			int arr[] = new int[n];
			BinarySearchTreeGeneric<Integer> bt = new BinarySearchTreeGeneric<>();
			for(int j=0;j<n;j++) {
				arr[i] = kb.nextInt();
				bt.insert(arr[i]);
			}
			int q = kb.nextInt();
			int queries[] = new int[q];
			for(int j=0; j<q;j++) {
				arr[j] = kb.nextInt();
				bt.remove(arr[j]);
			}
			bt.PreOrder();
		}
		kb.close();
	}

}
