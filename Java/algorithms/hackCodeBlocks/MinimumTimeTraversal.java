package hackCodeBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimumTimeTraversal {

	static class GridPlay {
		int origin_x; int origin_y; int end_x; int end_y;
		ArrayList<Pipe> a ;
		int min_time;
		public void getMinTime(ArrayList<Pipe> a, int indexOfPipe, int curr_time, int curr_x, int curr_y) {
			
			if(curr_x > end_x && curr_y > end_y) {
				return;
			} else if (curr_x == end_x && curr_y == end_y) {
				if(curr_time < min_time) {
					min_time = curr_time;
				}
			} 
		}
		public void findMinTime() {
			
			Collections.sort(a);
			Pipe p  = a.get(0);
		}
	}
	static class Pipe implements Comparable<Pipe> {
		int x1;
		int x2;
		int y1;
		int y2;
		int t;
		
		public int compareTo(Pipe p) {
			
			if(this.t > p.t) {
				return 1;
			} else {
				return -1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		ArrayList<GridPlay> arr = new ArrayList<GridPlay>();
		int T = kb.nextInt();
		for(int i = 0; i < T; i++ ) {
			
			GridPlay obj = new GridPlay();
			int nos = kb.nextInt();
			
			obj.origin_x = kb.nextInt();
			obj.origin_y = kb.nextInt();
			
			obj.end_x = kb.nextInt();
			obj.end_y = kb.nextInt();
			ArrayList<Pipe> a = new ArrayList<Pipe>();
			for(int j = 0; j < nos; j++) {
				Pipe p = new Pipe();
				p.x1 = kb.nextInt();
				p.y1 = kb.nextInt();
				p.x2 = kb.nextInt();
				p.y2 = kb.nextInt();
				p.t = kb.nextInt();
				a.add(p);
			}
			obj.a = new ArrayList<Pipe>(a);
			arr.add(obj);
			
		}
		
		display(arr);

	}
	
	public static void display(ArrayList<GridPlay> arr) {
		int c = 0;
		for(GridPlay gp: arr) {
			gp.findMinTime();
			System.out.println("#"+(c+1)+" : "+gp.min_time);
			c++;
		}
	}

}