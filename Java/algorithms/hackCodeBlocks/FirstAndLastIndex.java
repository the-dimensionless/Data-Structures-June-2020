package hackCodeBlocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstAndLastIndex {

	public static int findIndexOfLast(int[] arr, int l, int h, int ele, int n) {
		int mid = l + (h - 1);
		if (l <= h) {
			if (mid == 0 || ele < arr[mid - 1] && arr[mid] == ele) {
				return mid;
			} else if (ele < arr[mid]) {
				return findIndexOfFirst(arr, l, mid - 1, ele, n);
			} else {
				return findIndexOfFirst(arr, mid + 1, h, ele, n);
			}
		}
		return -1;
	}

	public static int findIndexOfFirst(int[] arr, int l, int h, int ele, int n) {
		int mid = l + (h - l);
		if (h >= l) {
			if (mid == 0 || ele > arr[mid - 1] && arr[mid] == ele) {
				return mid;
			} else if (ele > arr[mid]) {
				return findIndexOfFirst(arr, mid + 1, h, ele, n);
			} else {
				return findIndexOfFirst(arr, l, mid - 1, ele, n);
			}
		}
		return -1;

	}

	public static void finFirst(String in, int a[], int[] query) {
		for (int j = 0; j < query.length; j++) {
			System.out.println(findIndexOfFirst(a, 0, a.length-1, query[j], a.length) + " "
					+ findIndexOfLast(a, 0, a.length-1, query[j], a.length));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String in = br.readLine();
		String arr[] = in.split(" ");
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(arr[i]);
		}
		int Q = Integer.parseInt(br.readLine());
		int query[] = new int[Q];
		for (int i = 0; i < Q; i++) {
			query[i] = Integer.parseInt(br.readLine());
		}
		finFirst(in, a, query);

	}

}
