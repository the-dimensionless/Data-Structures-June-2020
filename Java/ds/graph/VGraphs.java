package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class VGraphs {

	private HashMap<String, Vertex> vlist;

	static class Vertex {
		String name;
		HashMap<Vertex, Integer> adjacency;

		Vertex(String n) {
			name = n;
			adjacency = new HashMap<>();
		}

		@SuppressWarnings("unused")
		private boolean equals(Vertex v1) {
//			Vertex v1 = (Vertex) v;
			return (this.name.equals(v1.name));
		}

		public void display() {
			String str = this.name;
			Set<Vertex> num = this.adjacency.keySet();
			for (Vertex ver : num) {
				str += ver.name + "(" + this.adjacency.get(ver) + ")";
			}
			str += "END";
			System.out.println(str);
		}

	}

	VGraphs() {
		vlist = new HashMap<String, Vertex>();
	}

	public void addVertex(String name) {
		if (this.vlist.containsKey(name))
			return;

		Vertex v = new Vertex(name);
		this.vlist.put(name, v);
	}

	public void removeVertex(String name) {
		if (!this.vlist.containsKey(name))
			return;

		Vertex v = this.vlist.get(name);
		Set<Vertex> ver = v.adjacency.keySet();

		for (Vertex v1 : ver) {
			v1.adjacency.remove(v);
		}

		this.vlist.remove(name);
	}

	public int numOfVertices() {
		return vlist.size();
	}

	public void addEdge(String source, String destination, int wt) {

		Vertex v1 = vlist.get(source);
		Vertex v2 = vlist.get(destination);

		if (v1 == null || v2 == null || v1.adjacency.containsKey(v2))
			return;

		v1.adjacency.put(v2, wt);
		v2.adjacency.put(v1, wt);

	}

	public void removeEdge(String source, String destination) {
		Vertex v1 = vlist.get(source);
		Vertex v2 = vlist.get(destination);

		if (v1 == null || v2 == null || !v1.adjacency.containsKey(v2))
			return;

		v1.adjacency.remove(v2);
		v2.adjacency.remove(v1);
	}

	public int numOfEdges() {
		int rv = 0;
		Collection<Vertex> vtces = this.vlist.values();
		for (Vertex v : vtces) {
			rv += v.adjacency.size();
		}
		rv = rv / 2;
		return rv;
	}

	public void display() {
		Set<String> vt = this.vlist.keySet();
		for (String s : vt) {
			Vertex v = this.vlist.get(s);
			v.display();
		}
	}

	public boolean hasPathIterative(String source, String destination) {
		Vertex v1 = this.vlist.get(source);
		Vertex v2 = this.vlist.get(destination);
		Queue<Vertex> q = new LinkedList<Vertex>();
		
		if (v1 == null || v2 == null)
			return false;

		if (v1.adjacency.containsKey(v2))
			return true;
		else {
			q.add(v1);
			Set<Vertex> hasSeen = new HashSet<Vertex>();	// try using Hash Map for O(1)
			hasSeen.add(v1);
			
			while (!q.isEmpty()) {
				v1 = q.poll();
				Set<Vertex> v = v1.adjacency.keySet();
				for (Vertex ver : v) {
					//System.out.println("vertex is "+ver.name);
					if (!hasSeen.contains(ver) && ver.adjacency.containsKey(v2)) {	// try using Hash Map for O(1)
						return true;
					} else if (!hasSeen.contains(ver)) {
						hasSeen.add(ver);
						q.add(ver);
					}
				}
			}
			
		}
		return false;
	}

	public boolean hasPathRecursively(String source, String destination) {
		Vertex v1 = this.vlist.get(source);
		Vertex v2 = this.vlist.get(destination);

		if (v1 == null || v2 == null)
			return false;

		ArrayList<Vertex> hasSeen = new ArrayList<Vertex>();	// try using Hash Map for O(1)
		return hasPathRecursively(v1, v2, hasSeen);

	}

	public boolean hasPathRecursively(Vertex v1, Vertex v2,	ArrayList<Vertex> hasSeen ) { // try using Hash Map for O(1)
		
		if (v1.adjacency.containsKey(v2))
			return true;
		else {
			hasSeen.add(v1);
			Set<Vertex> v = v1.adjacency.keySet();
				for (Vertex ver : v) {
					if (!hasSeen.contains(ver) && hasPathRecursively(ver, v2, hasSeen)) {
						return true;
					}
				}
		}
		return false;
	}

	public boolean isBipartite(String source) {
		
		Vertex start = this.vlist.get(source);
		
		Set<Vertex> set1 = new HashSet<Vertex>();
		Set<Vertex> set2 = new HashSet<Vertex>();
	
			
			for (String ss: this.vlist.keySet()) {
				Vertex vv = this.vlist.get(ss);
				if (start!=vv && vv.adjacency.containsKey(start)) {
					set1.add(vv);
				} else if (start != vv ) {
					set2.add(vv);
				}
			}
			
			for(Vertex v : set1) {
				for(String s: this.vlist.keySet()) {
					Vertex vv = this.vlist.get(s);
					if (v!=vv && vv.adjacency.containsKey(v)) {
						set1.add(vv);
					} else if (v!=vv) {
						set2.add(vv);
					}
				}
			}
		
		for(Vertex v: set1) {
			for (Vertex vv: set2) {
				if (v == vv) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public void printAllConnectedComps() {
		
		ArrayList<Vertex> listV = new ArrayList<Vertex>();
		ArrayList<Vertex> hasSeen = new ArrayList<Vertex>();
		
		Set<String> ve = this.vlist.keySet();
		for (String v: ve) {
			listV.add(this.vlist.get(v));
		}
		
		// list of all vertices has been prepared
		// choosing a random vertex
		
		while (!listV.isEmpty()) {
			System.out.println("\nComponent is ---> ");
			Vertex v = listV.get(0);
			hasSeen.add(v);
			System.out.print(v.name+" ");
			ArrayList<Integer> count = new ArrayList<Integer>();
			for (int i = 1; i < listV.size(); i++) {
				if (this.hasPathRecursively(v.name, listV.get(i).name) && !hasSeen.contains(listV.get(i))) {
					System.out.print(listV.get(i).name+" ");
					hasSeen.add(listV.get(i));
					count.add(i);
					
				}
			}
			
//			for(Integer i: count) {
//				listV.remove(i);
//			}
			listV.removeAll(hasSeen);
//			listV.remove(0);
//			printAll(v, listV, hasSeen);
		}
		
	}
	
	public static void printAll(Vertex v, ArrayList<Vertex> a, ArrayList<Vertex> hasSeen) {
		if (!a.contains(v)) {
			System.out.print(v.name+" ");
			hasSeen.add(v);
			a.remove(v);
		}
	
		Set<Vertex> set = v.adjacency.keySet();
		for ( Vertex v1 : set) {
			a.remove(v);
			if (!hasSeen.contains(v)) {
				printAll(v1, a, hasSeen);
			}
		}
	}
	
	public static void main(String[] args) {

		VGraphs g = new VGraphs();

		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A", "B", 10);
		g.addEdge("B", "C", 20);
		g.addEdge("A", "D", 30);
		g.addEdge("C", "D", 40);
		g.addEdge("D", "E", 50);
		g.addEdge("F", "G", 60);
		g.addEdge("E", "F", 70);
		g.addEdge("G", "E", 80);

		g.display();
		System.out.println("Number of vertices : " + g.numOfVertices());
		System.out.println("Number of edges : " + g.numOfEdges());
		g.addEdge("C", "G", 15);

		System.out.println("\nAfter insertion \n");
		g.display();
		System.out.println("Number of vertices : " + g.numOfVertices());
		System.out.println("Number of edges : " + g.numOfEdges());

		g.removeVertex("A");
		System.out.println("\nAfter deleting vertex \n");
		g.display();
		System.out.println("Number of vertices : " + g.numOfVertices());
		System.out.println("Number of edges : " + g.numOfEdges());

		g.removeEdge("D", "E");
		System.out.println("\nAfter deleting edge \n");
		g.display();
		System.out.println("Number of vertices : " + g.numOfVertices());
		System.out.println("Number of edges : " + g.numOfEdges());
		
		System.out.println("\nRecursively isPath from D to F ?");
		System.out.println(g.hasPathRecursively("D", "F"));
		
		System.out.println("\nIteratively isPath from D to F ?");
		System.out.println(g.hasPathIterative("D", "F"));
		
		g.addVertex("A");
		g.addVertex("Z");
		g.addEdge("A", "Z", 30); System.out.println();
		g.display();
		System.out.println("Number of vertices : " + g.numOfVertices());
		System.out.println("Number of edges : " + g.numOfEdges());
		
		System.out.println("\nRecursively isPath from A to F ?");
		System.out.println(g.hasPathRecursively("A", "F"));
		
		System.out.println("\nIteratively isPath from A to F ?");
		System.out.println(g.hasPathIterative("A", "F"));
		
		System.out.println("\nIs Bipartite ?");
		System.out.println(g.isBipartite("A"));
		
		// findConnected Components
		// display all such components
		// find if connected
//		System.out.println("is path from b to d ?");
//		System.out.println(g.hasPathRecursively("B", "D"));
		g.addEdge("A", "C", 34);
		System.out.println();
		g.printAllConnectedComps();

	}

}
