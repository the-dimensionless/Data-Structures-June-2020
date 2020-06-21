package hackCodeBlocks;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleEnough {

	public static ArrayList<Long> find(ArrayList<Long> arr) {
//		System.out.println("current lis is "+arr);
		ArrayList<Long> new_arr = new ArrayList<Long>();
		int flag = 0;
		for (int i=0; i<arr.size(); i++) {
			
			long element = arr.get(i);
			
			if (element > 1) {
				long floor = findFloor(element);
				new_arr.add(floor);
				new_arr.add(findModulo(element));
				new_arr.add(floor);
			} else {
				new_arr.add(element); flag++;
			}
		}
//		System.out.println("broken down into "+new_arr);
		if (flag == arr.size()) {
			return arr;
		} else return find(new_arr);
	}
	
	public static long findFloor(long n) {
		return (long) Math.floor(n/2);
	}
	public static long findModulo(long n) {
		return n%2;
	}
	public static void main(String[] args) {
//		Scanner kb = new Scanner(System.in);
//		long num = kb.nextLong();
//		long l = kb.nextLong();
//		long r = kb.nextLong();
		
		int num = 200; int l=0; int r=20;
		ArrayList<Long> al = new ArrayList<Long>();
		al.add((long) num);
		long a = System.currentTimeMillis();
		al = find(al); 
		int c = 0;
		System.out.println(al.toString());
		
		
		for(int i=0;i<al.size(); i++) {
			
			if(i >= (l-1) && i <= (r-1)) {
				if(al.get(i) == 1)
					c++;
			}
		}
		System.out.println(c);
		long b = System.currentTimeMillis();
		System.out.println(b-a);

	}

}
