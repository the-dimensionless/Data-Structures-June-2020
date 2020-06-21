package hackCodeBlocks;

import java.util.ArrayList;
import java.util.Scanner;


public class DJikstraFinalRunning {
	
	static class Graph {
		int vertices;
		int arr[][];
		boolean isVisited[];
		int source;
		
		public Graph (int V) {
			this.vertices = V;
			arr = new int[this.vertices][this.vertices];
			isVisited = new boolean[this.vertices];
			
			for (int i=0;i<this.vertices;i++) {
				for(int j=0;j<this.vertices;j++) {
					this.arr[i][j] = 0;
				}
			}
			
			for (int i=0; i<this.vertices; i++) {
				this.isVisited[i] = false;
			}
		}
		
		public void addEdge (int source, int destination, int wt) {
			this.arr[source][destination] = wt;
			this.arr[destination][source] = wt;
		}
		
		public int findMinIndex (int source, int[] path) {
			
			int index = -1;
			int min = Integer.MAX_VALUE;
			for (int i=0; i<this.vertices; i++) {
				if ( isVisited[i] == false && path[i] <= min) {
					min = path[i];
					index = i;
				}
			}
			return index;
		}
		
		public void djikstraPathFinder (int source) {
			this.source = source;
			
			int path[] = new int[this.vertices];
			for (int i= 0; i<this.vertices; i++) {
				path[i] = Integer.MAX_VALUE;
			}
			
			path[source] = 0;	
			
			for (int i = 0; i<this.vertices - 1; i++) {
				
				int indexOfMin = findMinIndex(source, path);
				isVisited[indexOfMin] = true;
				
				for (int j = 0; j<this.vertices; j++) {
					
					if (!isVisited[j] &&  this.arr[indexOfMin][j] != 0 && path[indexOfMin] != Integer.MAX_VALUE 
							&& (this.arr[indexOfMin][j] + path[indexOfMin] < path[j])) {
						
						if (this.arr[indexOfMin][j] != Integer.MAX_VALUE) {
							path[j] = this.arr[indexOfMin][j] + path[indexOfMin];
						}
					}
				}
			}
			
			display(path, path.length);
		}
		
		public void display (int[] path, int len) {
			for (int i = 0; i<len; i++) {
				if (i != this.source) {
					System.out.print(path[i]+" ");
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		ArrayList<Graph> arr = new ArrayList<Graph>();

		int test = kb.nextInt();
		for (int i = 0; i < test; i++) {

			int v = kb.nextInt();
			int e = kb.nextInt();
			Graph g = new Graph(v);
			for (int j = 0; j < e; j++) {
				int st = kb.nextInt()-1;
				int end = kb.nextInt()-1;
				int wt = kb.nextInt();
				g.addEdge(st, end, wt);
			}

			g.source = kb.nextInt() - 1;
			arr.add(g);

		}
		for (Graph g : arr) {
//			System.out.println("Here we go ");
			g.djikstraPathFinder(g.source);
			System.out.println();
		}

	}

}
