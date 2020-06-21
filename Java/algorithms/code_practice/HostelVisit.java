package code_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HostelVisit {
	
	public static long rocketDistance(long x1, long y1, long x2, long y2) {
		long d = (x1*x1 + y1*y1);
		return d;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int Q = kb.nextInt();
		int K = kb.nextInt(); long d = 0l;
		PriorityQueue<Long> queue = new PriorityQueue<Long>(Collections.reverseOrder()); // for max heap
		
		ArrayList<Long> a = new ArrayList<Long>(); // taking too much time
		for(int i = 0; i<Q; i++) {
			int type = kb.nextInt();
			if (type == 1) {
				long x = kb.nextInt();
				long y = kb.nextInt();
				long rcketDistance = rocketDistance(x, y, 0l, 0l); // Since Dean is always at origin
				d = rcketDistance;
				
				if (queue.size() < K) {
					queue.add(rcketDistance);
				} else {
					if(queue.peek() > d) {
						queue.poll();
						queue.add(d);
					}
				}
			} else if (type == 2) {
//				Collections.sort(a);
				System.out.println(queue.peek());
			}
		}
		

	}

}
