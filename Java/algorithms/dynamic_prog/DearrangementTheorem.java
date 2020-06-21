package dynamic_prog;

public class DearrangementTheorem {

	public static int dearrangeRecursively(int n) {
		if (n==0)
			return 1;
		if (n==1)
			return 0;
		if(n==2)
			return 1;
		
		return (n-1)*(dearrangeRecursively(n-1)+dearrangeRecursively(n-2));
	}
	
	public static int dearrangeDynamic(int n) {
		if (n==0)
			return 1;
		if (n==1)
			return 0;
		if(n==2)
			return 1;
		
		int dp[] = new int[n+1];
		dp[0] = 1; dp[1] = 0; dp[2] = 1;
		for(int i=3; i<=n;i++) {
			dp[i] = (i-1)*(dp[i-1]+dp[i-2]);
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		
	for(int i=0;i<10;i++) {
		System.out.print(dearrangeRecursively(i)+" ");
	}
	System.out.println();
	for(int i=0;i<10;i++) {
		System.out.print(dearrangeDynamic(i)+" ");
	}

	}

}
