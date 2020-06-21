package code_practice;

import java.util.ArrayList;
import java.util.Scanner;



public class Djikstra {

	static class Graph {

		int V;
		int arr[][];
		boolean isVisited[];
		int source = 0;

		Graph(int V) {
			this.V = V;
			this.arr = new int[V][V];
			this.isVisited = new boolean[V];
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					arr[i][j] = Integer.MAX_VALUE;
				}
				isVisited[i] = false;
			}
		}

		void addEdge(int source, int destination, int weight) {
			// for undirected graph
			this.arr[source ][destination ] = weight;
			this.arr[destination ][source] = weight;
		}

		void disp(int source, int shortest[]) {
			for (int i = 0; i < V; i++) {
				if (i != source) {
					System.out.print(shortest[i] + " ");
				}
			}
		}
		void display() {
			for(int i=0; i<this.V; i++) {
				for(int j=0; j<this.V;j++) {
					System.out.print(this.arr[i][j] + "             ");
				}System.out.println();
			}
		}

		int findMinimum( int shortest[]) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int i = 0; i < V; i++)
				if (this.isVisited[i] == false && arr[source][i] <= min) {
					min = arr[source][i];
					index = i;
				}

			return index;
		}

		public void findDjikstra(int source) {
			int shortest[] = new int[V]; 
			this.display();
			for (int i = 0; i < V; i++) {
				shortest[i] = Integer.MAX_VALUE;
				this.isVisited[i] = false;
			}
			shortest[source] = 0;
			this.isVisited[source] = true;

			for (int i = 0; i <V-1; i++) {
			
				int minD = findMinimum(shortest);
				this.isVisited[minD] = true;
				shortest[i] = arr[source][minD];
				System.out.println("current minimum index is "+minD+" and ele is "+arr[source][minD]);
				for (int j = 0; j < V; j++) {
					if ((isVisited[j] == false) && (arr[minD][j] != 0) && (shortest[minD] != Integer.MAX_VALUE)
							&& (shortest[minD] + arr[minD][j] < shortest[j])) {
						shortest[j] = shortest[minD] + arr[minD][j];
					}else {
						shortest[j] = arr[source][j];
						
					}
				}
				System.out.println("after trial -----------> ");
				this.disp(source, shortest);
				
			}
			disp(source, shortest);
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
			g.findDjikstra(g.source);
			arr.add(g);

		}

	}

}
