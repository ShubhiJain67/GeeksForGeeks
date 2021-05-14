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
		    int num=sc.nextInt();
		    CardRotation(num);
		}
	}
	public static void CardRotation(int num){
	    int ans[]=new int[num];
	    for(int i=0;i<num;i++){
	        ans[i]=0;
	    }
	    ans[1]=1;
	    int lastIndex=1;
	    
	    for(int i=2;i<=num;i++){
	       int temp=i;
	       int curIndex=(lastIndex+1)%num;
	       while(temp!=0){
	            if(ans[curIndex]==0)temp--;
	            curIndex=(curIndex+1)%num;
	       }
	       while(ans[curIndex]!=0){
	           curIndex=(curIndex+1)%num;
	       }
	       ans[curIndex]=i;
	       lastIndex=curIndex;
	    }
	    display(ans);
	}
	public static void display(int []arr){
	    for(int i=0;i<arr.length;i++){
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();
	}
}
