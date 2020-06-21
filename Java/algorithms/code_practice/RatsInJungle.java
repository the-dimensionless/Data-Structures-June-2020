package code_practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RatsInJungle {

	public static void find(int a[]) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int in_array = 0; int c = 0;
		int not_array = 0;
		for(int i = 0; i<a.length;i++) {
			
			if(hm.containsKey(a[i])) {
				int val = hm.get(a[i]);
				hm.put(a[i], val + 1);
			} else {
				hm.put(a[i],1);
				c++;
			}
		}
		
		 Set set = hm.keySet();
	      
	      // Get an iterator
	      Iterator i = set.iterator();
	     
	      // Display elements 
	      while(i.hasNext()) {
	         int me = (int) i.next();
	        int y = me;
	        int x = (Integer)hm.get(me);
	        System.out.println("Element "+y+" count "+x);
	        if(y-x>=0) {
	        	not_array += y-x+1;
	        	System.out.println("not in array "+not_array);
	        } else if(y==0) {
	        	not_array += 0; 
	        	System.out.println("not in array "+not_array);
	        } else {
//	        	not_array += x - ( (x-y) % x);
	        	System.out.println("not in array "+not_array);
	        }
	        
	  
	      }
	      in_array += a.length; 
	      System.out.println(hm);
//	      System.out.println(set);
	      System.out.println("in array "+in_array+" and not in array "+not_array);
	      System.out.println(in_array + not_array);
		
		
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int a[]=new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = kb.nextInt();
		}
		
		find(a);

	}

}
