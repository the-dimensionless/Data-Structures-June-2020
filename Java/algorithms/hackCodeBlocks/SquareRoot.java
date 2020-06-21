package hackCodeBlocks;

import java.util.Scanner;

public class SquareRoot {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		int T = kb.nextInt();
		Integer arr[] = new Integer[T];

		for (int i = 0; i < T; i++) {
			arr[i] = kb.nextInt();
		}

		int beforePoint = 0;
		int afterPoint = 0;

		for (int i = 0; i < T; i++) {
			Double d = (double) Math.sqrt(arr[i]);
			String str[] = d.toString().split("\\.");

			if (str.length == 1) {
				System.out.println(String.format("%.4f", d));
			} else if (str[1].length() >= 4) {
				System.out.println(str[0] + "." + str[1].substring(0, 4));
			} else {
				System.out.println(String.format("%.4f", d));
			}

		}

	}
}
