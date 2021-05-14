/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    System.out.println(BiTonic(arr,n-1));
		}
	}
	private static int BiTonic(int arr[],int n){
        int inc=0,dpInc[]=new int[n+1];
        for(int i=0;i<=n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i])
                    dpInc[i]=Math.max(dpInc[j],dpInc[i]);
            }
            dpInc[i]++;
            inc=Math.max(inc,dpInc[i]);
        }
        int dec=0,dpDec[]=new int[n+1];
        for(int i=n;i>=0;i--){
            for(int j=i+1;j<=n;j++){
                if(arr[j]<arr[i])
                    dpDec[i]=Math.max(dpDec[j],dpDec[i]);
            }
            dpDec[i]++;
            dec=Math.max(dec,dpDec[i]);
        }
        int mid=0;
        for(int i=0;i<=n;i++){
            mid=Math.max(mid,dpInc[i]+dpDec[i]-1);
        }
        // for(int i:dpInc)
        //     System.out.print(i+" ");
        // System.out.println();
        // for(int i:dpDec)
        //     System.out.print(i+" ");
        // System.out.println();
        // System.out.println(inc+" "+dec+" "+mid);
        return mid;
    }
}