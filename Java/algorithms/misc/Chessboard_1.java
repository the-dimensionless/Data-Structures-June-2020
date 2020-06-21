package misc;

import java.util.Scanner;

public class Chessboard_1 {

	static int count = 0;;
	static String answer = "";

	public void getPaths(int n, int x, int y, String res) {
		System.out.println(res);
		if (x > n || y > n)
			return;

		if (x <= n && y <= n) {

			if (x == n && y == n) {
				answer += res + " ";
				count++;
			}

			boolean isRook = ( (x == 0) || (x == y)) || ( (y == n) || (y == 0));
			boolean isBishop = (x == y) || (x + y == n);

			String knight1 = res + "K{" + (x + 2) + "-" + (y + 1) + "}";
			String knight2 = res + "K{" + (x + 1) + "-" + (y + 2) + "}";

			if (!isRook && !isBishop) {
				new Chessboard_1().getPaths(n, x + 2, y + 1, knight1);
				new Chessboard_1().getPaths(n, x + 1, y + 2, knight2);
			}

			if (!isBishop && isRook) {

				for (int i = 1; i <= (n - x); i++) {
					new Chessboard_1().getPaths(n, x + i, y, new String(res + "R{" + (x + i) + "-" + (y) + "}"));
					new Chessboard_1().getPaths(n, x + i, y, new String(res + "R{" + (x + i) + "-" + (y) + "}"));
				}

				for (int i = 1; i <= (n - y); i++) {
					new Chessboard_1().getPaths(n, x, y + i, new String(res + "R{" + (x) + "-" + (y + i) + "}"));
					new Chessboard_1().getPaths(n, x, y + i, new String(res + "R{" + (x) + "-" + (y + i) + "}"));

				}
			}

			if (isRook && isBishop) {

				for (int j = 1; j <= (n - x); j++) {
					new Chessboard_1().getPaths(n, x + j, y + j, new String(res + "B{" + (x + j) + "-" + (y + j) + "}"));
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();

		new Chessboard_1().getPaths(n - 1, 0, 0, "{0-0}");
		System.out.println(answer);
		kb.close();

	}

}
