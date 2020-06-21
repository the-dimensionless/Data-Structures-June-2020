package code_practice;

import java.util.Scanner;
import java.util.Stack;

public class Histogram {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long[] arr = new long[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
		}

		long globalMax = 0;
		long localMax = 0;

		Stack<Integer> stack = new Stack<Integer>();

		int i = 0;
		while (i < arr.length) {

			if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
				stack.push(i);
				i++;
			}

			else {

				long x = arr[stack.pop()];

				int rightH = i;

				if (stack.isEmpty()) {
					localMax = rightH * x;
				} else {
					int leftH = stack.peek();
					localMax = (rightH - leftH - 1) * x;
				}

				if (localMax > globalMax) {
					globalMax = localMax;
				}

			}

		}

		while (!stack.isEmpty()) {

			long x = arr[stack.pop()];

			int R = i;

			if (stack.isEmpty()) {
				localMax = R * x;
			} else {
				int L = stack.peek();
				localMax = (R - L - 1) * x;
			}

			if (localMax > globalMax) {
				globalMax = localMax;
			}

		}

		System.out.println(globalMax);
	}
}