package code_practice;

import java.util.LinkedList;
import java.util.Scanner;

public class FirstNegative {


class Queue {

	protected int size;

	protected int front;
	protected int[] data;

	public Queue() {
		this.size = 0;
		this.front = 0;
		this.data = new int[5];
	}

	public Queue(int cap) {
		this.size = 0;
		this.front = 0;
		this.data = new int[cap];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void enqueue(int item) throws Exception {
		if (this.size() == this.data.length) {
			int[] oa = this.data;
			int[] na = new int[oa.length * 2];
			for (int i = 0; i < this.size(); i++) {
				int idx = (i + front) % oa.length;
				na[i] = oa[idx];
			}

			this.data = na;
			this.front = 0;
		}

		this.data[(front + size) % this.data.length] = item;
		size++;

	}

	public int dequeue() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");

		}

		int rv = this.data[front];
		front = (front + 1) % this.data.length;
		size--;

		return rv;

	}

	public int getFront() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}

		int rv = this.data[front];

		return rv;
	}

	public void display() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			int idx = (i + front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
        System.out.print("END");
	}

}
    public static void first_negative(int[] arr,int n,int k) throws Exception{ 
		int len = arr.length;
		int windows[] = new int[len - k + 1];

		for (int i = 0; i < windows.length; i++) {
			windows[i] = 0;
		}

		for (int i = 0; i < len - 2; i++) {
			if (arr[i] < 0) {
				windows[i] = arr[i];
			} else if (arr[i + 1] < 0) {
				windows[i] = arr[i + 1];
			} else if (arr[i+2] < 0) {
				windows[i] = arr[i + 2];
			} else {
				
			}
		}
		
		for (int i = 0; i < windows.length; i++) {
			System.out.print(windows[i] + " ");
		}
		
    } 


	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

        int t = scn.nextInt();
        
        while(t > 0){
		    int n = scn.nextInt();
		    int k = scn.nextInt();
		
		    int[] arr = new int[n];
		
		    for(int i = 0;i < n;i++){
		        arr[i] = scn.nextInt();
		    }
		    
		    first_negative(arr,n,k);
		 
		t--;
	    }
		 
	}

}
