package misc;


public class FindCoeffsBeforeAfterSubstring {

	public static void find(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		String answer = "";
		
		for (int i=0; i<a.length()-lengthB+1; i++) {
			
			String subs = a.substring(i, i+lengthB);
			if (subs.equals(b)) {
				
				if(i-1 != -1) {
					answer += a.charAt(i-1);
				}
				if (i+lengthB != lengthA) {
					answer += a.charAt(i+lengthB);
				}
			}
		}
		
		System.out.println(answer);
	}

	public static void main(String[] args) {
		
//		Scanner kb = new Scanner(System.in);
		
//		System.out.println("Enter a string");
//		String a = kb.nextLine();
//		
//		System.out.println("Enter a tester string");
//		String b = kb.nextLine();
//		
//		find(a,b);
		find("abcXY123XYijk","XY");
		find("XY123XY","XY");
		find("XY1XY","XY");
		
//		kb.close();

	}

}
