package code_practice;

public class Permutations {
	static int count = 0;

	static void perm(String s, String ans) {
		
		if (s.length() == 0) {
			System.out.print(ans + " ");
			count++;
			return;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String restOfString = s.substring(0,i) +
					s.substring(i+1);
			
			perm(restOfString, ans + ch);
		}
	}
	public static void main(String[] args) {
		String s = "abc";
		perm(s,"");
		System.out.println("\nTotal no of permutations is : "+count);

	}

}
