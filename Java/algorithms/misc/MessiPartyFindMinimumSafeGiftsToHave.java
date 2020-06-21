package misc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MessiPartyFindMinimumSafeGiftsToHave {
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int t = kb.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			int friends = kb.nextInt();
			
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for (int j = 0; j < friends; j++) {
				q.add(kb.nextInt());
			}
			int least = kb.nextInt();
			
			find(q, friends, least);
		}
		kb.close();
	}

	private static void find(PriorityQueue<Integer> q, int friends, int least) {
		
		Integer total = 0;
		int count = 0;
		
		int rest[] = new int[least];
		while(q.size()!=0) {
			if (count == least) {
				break;
			}
			rest[count++] = q.poll();
		}
		total = friends * rest[least-1];
		for (int i = 0; i < rest.length-1; i++) {
			total -= (rest[least-1] - rest[i]);
		}
		System.out.println(total);
	}

}
