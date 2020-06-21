package bitMagic;

public class CheckPowerOfTwo {

	public static void main(String[] args) {
		// x >> a --> divide x by 2^a (Integer division)
		// x << a --> multiply x by 2^a
		
		int x = 8;
		while (x > 0) {
			if (x==2) {
				System.out.println("Yes");
				return;
			}
			x = x>>2;
		}
		
		System.out.println("No");

	}

}
