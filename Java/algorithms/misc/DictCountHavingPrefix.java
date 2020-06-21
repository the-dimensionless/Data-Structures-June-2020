package misc;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DictCountHavingPrefix {
	
	public static int findPrefix(String test, PriorityQueue<String> q) {
		int count = 0;
		
		Iterator<String> it = q.iterator();
		
		while (it.hasNext()) {
			String tester = it.next();
			if (tester.startsWith(test)) {
				count++;
			} else {
				break;
			}
		}
		
		return count;
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
		Scanner kb = new Scanner(System.in);
		DataInputStream is = new DataInputStream(System.in);
	
		int n = Integer.parseInt(is.readLine());
		
		PriorityQueue<String> q = new PriorityQueue<String>();
		
		for (int i = 0; i < n; i++) {
			
			String input[] = is.readLine().split(" ");
			if (input[0].equals("add")) {
				q.add(input[1]);
				
			} else {
				System.out.println(findPrefix(input[1], q));
			}
			
		}
		kb.close();
		
	}

}
