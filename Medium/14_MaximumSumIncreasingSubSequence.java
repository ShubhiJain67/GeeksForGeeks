
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int len=sc.nextInt();
		    int arr[]=new int[len];
		    for(int i=0;i<len;i++)
		        arr[i]=sc.nextInt();
		    int dp[]=new int[len],max=0;
		    for(int i=0;i<len;i++){
		        dp[i]=arr[i];
		        for(int j=i-1;j>=0;j--)
		            if(arr[j]<arr[i])
		                dp[i]=Math.max(dp[i],dp[j]+arr[i]);
		        max=Math.max(max,dp[i]);
		    }
		    System.out.println(max);
		}
	}
}