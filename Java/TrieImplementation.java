package advancedDataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrieImplementation {
	
	static class Trie {
		private Node root;
		int numberOfWords;
		
		class Node {
			char ch;
			HashMap<Character, Node> children;
			boolean isTerminal;
			
			public Node (char ch, boolean isEnd) {
				this.ch = ch;
				this.children = new HashMap<Character, Node>();
				this.isTerminal = isEnd;
			}
			
		}
		
		// default contructor
		public Trie () {
			this.root = new Node('\0', false);
		}
		
		// Wrapper function for insertion
		public void insert (String word) {
			this.insert(word, this.root);
		}
		
		// Actual function for insertion
		private void insert (String word, Node parent) {
			if (word.length() == 0) {
				if (parent.isTerminal) {
					
				} else {
					parent.isTerminal = true;
				}
			} else {
				char ch = word.charAt(0);
				String ros = word.substring(1);
				
				Node node = parent.children.get(ch);
				if (node == null) {
					node = new Node(ch, false);
					parent.children.put(ch, node);
				}
				
				this.insert(ros, node);
			}
		}
		
		
		// Wrapper function for display
		public void display() {
			this.display(this.root, "");
		}
		
		// Actual function for display
		private void display (Node node, String result) {
			if (node.isTerminal) {
				System.out.println(result);
			}
			
			Set<Map.Entry<Character, Node>> entry = node.children.entrySet();
			for (Map.Entry<Character, Node> e : entry) {
				display(e.getValue(), result + e.getKey());
			}
			
		}
		
		// Wrapper function for search
		public void search (String word) {
			this.search(word, root);
		}
		
		// Actual function for search
		private void search (String target, Node node) {
			if (target.length() == 0) {
				System.out.println("Word found !!!");
				return;
			} else {
				char ch = target.charAt(0);
				String ros = target.substring(1);
				
				Node newNode = node.children.get(ch);

				if (newNode == null) {
					System.out.println("No Such Word");
				} else {
					search (ros, newNode);
				}
			}
		}
		
		// Wrapper for removing a node
		public void remove (String s) {
			remove(s, this.root);
		}
		
		// Actual Function for removal
		private Node remove (String target, Node node) {
			if (target.length() == 0 && !node.children.isEmpty()) {
				node.isTerminal = false;
				return node;
			} else if (target.length() == 0 && node.children.isEmpty()) {
				node.isTerminal = false;
				return null;
			}
			
			char ch = target.charAt(0);
			String ros = target.substring(1);
			
			Node newNode = node.children.get(ch);
			if (newNode == null) {
				System.out.println("No such word to delete");
				return node;
			} else {
				Node child = remove (ros, newNode);
				if (child == null) {
					node.children.remove(ch);
				}
				return node;
			}
		}
		
		// Wrapper for custom tree
		public void customDisplay () {
			this.customDisplay(root);
		}
		
		// Actual function for customTree 
		private void customDisplay (Node node) {
			if (node.children.isEmpty()) {
				System.out.println("-->END");
			}
			System.out.println(node.ch);
			
			Set<Map.Entry<Character, Node>> entry = node.children.entrySet();
			for (Map.Entry<Character, Node> hm : entry) {
				System.out.print(hm.getKey()+" ");
				customDisplay(hm.getValue());
			}
		}
	}

	public static void main(String[] args) {
		Trie t = new Trie ();
		t.insert("art");
		t.insert("arts");
		t.insert("bug");
		t.insert("see");
		t.insert("sea");
		t.insert("seen");
		t.display();
		t.search("seen");
		t.search("wow");
		t.remove("art");
		System.out.println("after removing art ---->");
		t.display();
		t.remove("arts");
		System.out.println("After removing arts ---->");
		t.display();
		t.customDisplay();
	}

}
