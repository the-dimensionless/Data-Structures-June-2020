package graph;

import java.util.Scanner;

public class dij {

	static class ShortestPath {
		static int V = 0;
		static int source = 0;
		int minDistance(int dist[], boolean isVisited[]) {
			int min = Integer.MAX_VALUE, min_index = -1;

			for (int v = 0; v < V; v++)
				if (isVisited[v] == false && dist[v] <= min) {
					min = dist[v];
					min_index = v;
				}

			return min_index;
		}

		void display(int arr[]) {
			for (int i = 0; i < V; i++) {
				
				if (i!= source && arr[i] != 0) {
					System.out.print(arr[i] + " ");
				} else if (i!=source && arr[i] == 0) {
					System.out.print("-1 ");
				}
				
			}
				
		}

		void dijkstra(int graph[][], int src) {
			int dist[] = new int[V];
			boolean isVisited[] = new boolean[V];
			for (int i = 0; i < V; i++) {
				dist[i] = Integer.MAX_VALUE;
				isVisited[i] = false;
			}

			dist[src] = 0;

			for (int count = 0; count < V - 1; count++) {
				int u = minDistance(dist, isVisited);
				isVisited[u] = true;

				for (int v = 0; v < V; v++)
					if (!isVisited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
							&& dist[u] + graph[u][v] < dist[v])
						dist[v] = dist[u] + graph[u][v];
			}
			display(dist);
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int test = kb.nextInt();
		for (int i = 0; i < test; i++) {

			int v = kb.nextInt();
			int e = kb.nextInt();
			int arr[][] = new int[v][v];

			for (int k = 0; k < v; k++) {
				for (int j = 0; j < v; j++) {
					arr[k][j] = 0;
				}
			}
			for (int j = 0; j < e; j++) {
				int st = kb.nextInt() - 1;
				int end = kb.nextInt() - 1;
				int wt = kb.nextInt();
				arr[st][end] = wt;
				arr[end][st] = wt;
			}
			int source = kb.nextInt() - 1;
			ShortestPath t = new ShortestPath();
			t.V = v;
			t.source = source;
			t.dijkstra(arr, source);
			kb.close();
		}
	}
}
