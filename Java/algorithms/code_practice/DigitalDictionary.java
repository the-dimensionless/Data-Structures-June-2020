package code_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class DigitalDictionary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Trie t = new Trie();
		for(int i=1;i<=n;i++) {
			t.insert(br.readLine());
		}
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			t.search(br.readLine());
		}

//		Trie t = new Trie();
//		t.insert("pet"); t.insert("peter"); t.insert("rat"); t.insert("rack");
//		t.search("pe");
//		t.search("pet");
//		t.search("r");
//		t.search("rac");
//		t.search("rat");
	}

	static class Trie {
		private Node root;
		int numWords;

		class Node {
			char data;
			HashMap<Character, Node> children;
			boolean isTerminal;

			public Node(char ch, boolean isEnd) {
				this.data = ch;
				this.children = new HashMap<Character, Node>();
				this.isTerminal = isEnd;
			}
		}

		Trie() {
			root = new Node('\0', false);
		}

		public void insert(String word) {
			this.insert(word, this.root);
		}

		private void insert(String word, Node parent) {
			if (word.length() == 0) {
				if (parent.isTerminal) {

				} else {
					parent.isTerminal = true;
					this.numWords++;
				}
				return;
			} else {
				char ch = word.charAt(0);
				String ros = word.substring(1);

				Node child = parent.children.get(ch);
				if (child == null) {
					child = new Node(ch, false);
					parent.children.put(ch, child);
				}
				this.insert(ros, child);
			}
		}

		private void printAll(Node node, String target) {
			
			TreeMap<Character, Node> tm = new TreeMap<Character, Node>(node.children);
			Set<Map.Entry<Character, Node>> entry = tm.entrySet();
			if (entry == null) {
				return;
			}
			
			for (Map.Entry<Character, Node> e : entry) {
				char ch = e.getKey();
				if(e.getValue().isTerminal) {
					System.out.println(target + ch);
				}

				printAll(e.getValue(), target + ch);
			}
		}

		private void search(Node node, String target, String s) {
			if (target.length() == 0) {
				if (node.isTerminal) {
					System.out.println(s);
				}
				printAll(node, s);
				return;
			}
			char ch = target.charAt(0);
			Node child = node.children.get(ch);
			if (child == null) {
				System.out.println("No suggestions");
				this.insert(s);
			}
			else {
				this.search(child, target.substring(1), s);
			}
		}

		public void search(String s) {
			this.search(this.root, s, s);
		}

		private Node remove(Node node, String target) {
			if (target.length() == 0 && !node.children.isEmpty()) {
				node.isTerminal = false;
				return node;
			} else if (target.length() == 0 && node.children.isEmpty()) {
				return null;
			}

			char ch = target.charAt(0);
			Node child = node.children.get(ch);
			if (child == null && target.length() != 0) {
				System.out.println("No such word to delete");
				return node;
			} else {
				Node newNode = this.remove(child, target.substring(1));
				if (newNode == null) {
					node.children.remove(ch);
				}
				return node;
			}

		}

		public void remove(String s) {
			char ch = s.charAt(0);
			this.remove(this.root, s);
		}

		private void displayCustomTree(Node node) {
			if (node.children.isEmpty()) {
				System.out.println("END");
			}
			System.out.println(node.data);
			Set<Map.Entry<Character, Node>> entry = node.children.entrySet();
			for (Map.Entry<Character, Node> hm : entry) {
				System.out.print(hm.getKey() + " ");
				displayCustomTree(hm.getValue());
			}

		}

		public void displayCustomTree() {
			this.displayCustomTree(this.root);
		}
	}

}
