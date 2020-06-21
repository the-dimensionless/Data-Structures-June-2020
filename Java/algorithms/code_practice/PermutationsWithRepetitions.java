package code_practice;

public class PermutationsWithRepetitions {
	static int count = 0;

	static void perm(String s, String ans) {
		
		if (s.length() == ans.length()) {
			System.out.print(s + " ");
			count++;
			return;
		}
		
		for (int i = 0; i < ans.length(); i++) {
			char ch = ans.charAt(i);
			perm(s + ch, ans);
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		perm("",s);
		System.out.println("\nTotal no of permutations is : "+count);

	}


}
