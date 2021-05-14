/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		while(testCase-->0){
		    int n=sc.nextInt();
		  //  System.out.println(getAnsRec(n,new long[n+1]));
		  //  System.out.println(getAnsIter(n));
		    System.out.println(TwoPointer(n));
		}
	}
	private static long getAnsRec(int n,long dp[]){
	    if(n<=1)
	        return 1;
	   if(dp[n]!=0)
	    return dp[n];
	   long single=getAnsRec(n-1,dp)%1000000007;
	   long pair=(getAnsRec(n-2,dp)%1000000007*(n-1))%1000000007;
	   dp[n]=single+pair;
	   return dp[n]%1000000007;
	}
	private static long getAnsIter(int n){
	    long dp[]=new long[n+1];
	    int mod=1000000007;
	    dp[0]=1;
	    dp[1]=1;
	    for(int i=2;i<=n;i++){
	        dp[i]=(dp[i-1]%mod+((dp[i-2]%mod)*(i-1))%mod);
	    }
	   return dp[n]%mod;
	}
	private static long TwoPointer(int n){
        long first=1;
        long second=1;
        int mod=1000000007;
        long ans=1;
        for(int i=2;i<=n;i++){
            ans=((first%mod*(i-1))%mod+second%mod)%mod;
            first=second;
            second=ans;
        }
        return ans;
    }
}