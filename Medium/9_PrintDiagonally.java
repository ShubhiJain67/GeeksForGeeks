/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int inp=sc.nextInt();
		for(int i=1;i<=inp;i++){
		    int n=sc.nextInt();
		    int ar[][]=new int[n][n];
		    for(int j=0;j<n;j++){
		        for(int k=0;k<n;k++){
		            ar[j][k]=sc.nextInt();
		        }
		    }
		    PrintDiagonally(ar,n);
		}
	}
	public static void PrintDiagonally(int [][]ar,int n){
	    ArrayList<Integer>[] ans = new ArrayList[n+n];
	    for (int i = 0; i < n+n; i++) { 
            ans[i] = new ArrayList<Integer>(); 
        }
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            ans[i+j].add(ar[i][j]);
	        }
	    }
	    display(ans,n);
	}
	public static void display(ArrayList<Integer>[] a,int n){
	    for(int i=0;i<n+n;i++){
	        for(int j=0;j<a[i].size();j++){
	            System.out.print(a[i].get(j)+" ");
	        }
	    }
	    System.out.println();
	}
}
