package hackCodeBlocks;

import java.util.Scanner;

public class AggressiveCows2 {

	static int minDist(int stalls[],int n,int k){

		int s = stalls[0];
		int e = stalls[n-1];

		int ans = 0;
		int mid = 0;
		while(s+1<e){      //here if you take s<e, it will become an infinite loop once we reach the required answer.
		    mid = (s+e)/2;

		    if(isValid(stalls,n,k,mid)==1){
		        s = mid;
		    }
		    else{
		        e = mid;
		    }
		}
		return s;
	}
	static int isValid(int stalls[],int n,int s,int current_ans){

		int cow = 1;
		int currently_alloted = stalls[0];

		for(int i=1;i<n;i++){

		    if(stalls[i]-currently_alloted >= current_ans){
		        cow++;
		        if(cow==s){
		            return 1;
		        }
		        currently_alloted = stalls[i];

		    }
		}
		return 0;
		}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int stalls = kb.nextInt();
		int cows = kb.nextInt();
		int indexes[] = new int[stalls];
		for(int i=0; i<stalls; i++) {
			indexes[i] = kb.nextInt();
		}
		
		System.out.println(minDist(indexes, cows, stalls));

	}

}
