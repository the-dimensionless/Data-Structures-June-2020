package code_practice;

import java.util.Scanner;
import java.util.Stack;

public class Histogram2 {

	public static void main(String[] args) {
		 Scanner kb=new Scanner(System.in);
		 int t=kb.nextInt();
		 while(t>0)
		 {
		     int n=kb.nextInt();
		     int arr[]=new int[n];
		     int area,max_area=0;
		     for(int i=0;i<n;i++)
		     arr[i]=kb.nextInt();
		     int i=0,top;
		     Stack<Integer> stack =new Stack<Integer>();
		     while(i<n)
		     {
		         if(stack.empty()|| arr[stack.peek()]<=arr[i])
		         stack.push(i++);
		         else
		         {
		             top=stack.pop();
		             area=arr[top] * (stack.empty() ? i : i - stack.peek() - 1);
		            
		         if(area>max_area)
		         max_area=area;
		         }
		     }
		     while(!stack.empty())
		     {
		         top=stack.pop();
		             area=arr[top] * (stack.empty() ? i : i - stack.peek() - 1);
		            
		         if(area>max_area)
		         max_area=area;
		     }
		     System.out.println(max_area);
		     t--;
		 }

	}

}
