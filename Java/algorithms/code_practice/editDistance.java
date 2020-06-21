package code_practice;

public class editDistance {

	public static int findED(String s1, String s2, int x, int y) {

		if(x==0) {
			return y;
		} else if(y==0) {
			return x;
		} else if ((s1.charAt(x-1) == s2.charAt(y-1) ) ) {
			return findED(s1, s2, x-1, y-1);
		} else {
			return 1 + Math.min(Math.min(findED(s1, s2, x - 1, y), findED(s1, s2, x, y - 1)),
					findED(s1, s2, x - 1, y - 1));
		}
	}

	public static int findEDdp(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int c=0;
		int arr[][]= new int[l1+1][l2+1];
		for(int i=l1;i>=0;i--) {
			arr[i][l2] = c;
			c++;
		}
		c = 0;
		for(int i=l2;i>=0;i--) {
			arr[l1][i] = c;
			c++;
		}
		for(int i=0;i<l1+1;i++) {
			for(int j=0;j<l2+1;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=l1-1;i>=0;i--) {
			for(int j=l2-1;j>=0;j--) {
				
				if(s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i+1][j+1];
				} else {
					arr[i][j] = 1 + Math.min(Math.min(arr[i+1][j], arr[i][j+1]), arr[i+1][j+1]);
				}
			} 
		} System.out.println();
		for(int i=0;i<l1+1;i++) {
			for(int j=0;j<l2+1;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		return arr[0][0];
	}
//	arr[0][0] = 1 + Math.min(Math.min(arr[1][1], arr[1][0]), arr[0][1]);
	public static void main(String[] args) {

		String s1 = "dabc"; int l1 = s1.length();
		String s2 = "abcd"; int l2 = s2.length();
//		System.out.println(findED(s1, s2, l1, l2));
		System.out.println(findEDdp(s1, s2));
	}

}
