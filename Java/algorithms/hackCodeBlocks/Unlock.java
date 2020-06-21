package hackCodeBlocks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Unlock {

	static long largest = Integer.MIN_VALUE;
	
//	public static void tryCombo(String s,int index, long number, int current_swaps, int swaps) {
//	
//		if (current_swaps < 0)
//			return ;
//		if (current_swaps == 0) {
//			if (number > largest)
//					largest = number;
//		} else {
//			long globe = Integer.MIN_VALUE;
//			for(int j=index + 1; j<s.length(); j++) {
////				System.out.println("Leaving as it is ");
//				tryCombo(s, index+1, Integer.parseInt(s), current_swaps, swaps );
//				
////				System.out.println("Current index element "+s.charAt(index)+" at position "+index);
////				System.out.println("Trying to replace with "+s.charAt(j)+ " at position "+j);
//				StringBuffer sb = new StringBuffer(s);
//				char ch1 = s.charAt(index); char ch2 = s.charAt(j);
//				sb.replace(index, index+1, ""+ch2);
//				sb.replace(j, j+1, ""+ch1);
//				String s1 = new String(sb);
////				System.out.println("Resultant String "+s1);
//				tryCombo(s1, index+1, Integer.parseInt(s1), current_swaps-1, swaps );
//				
//			}
//			return ;
//		}
//	}
//	 Above method results in timeLimit
//
//	public static void trickNtreat(int arr[], String s, int swaps) {
//		Arrays.sort(arr);
//		
//		for ( int i=0; i< s.length(); i++) {
//			
//			if(arr[i] == Integer.parseInt(""+s.charAt(i))) {
//				continue;
//			} else {
//				char ch1 = s.charAt(i);
//				
//				
//			}
//		}
//	}
	public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            hm.put(arr[i], i);
        }
        int num = n;
        int m = 0;
        while(m<n && k>0) {
            int hold = hm.get(num-m);
            if(hold==n-num+m) { 
                m++;
                continue;
            } else { 
                int temp=arr[m];
                arr[m]=arr[hold];
                arr[hold]=temp;
                hm.put(arr[hold], hold);
                hm.put(arr[m],m);
                m++;
                k--;
            }
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }


	}

