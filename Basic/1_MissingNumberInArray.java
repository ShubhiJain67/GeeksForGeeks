/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int size=sc.nextInt();
		    int sum=0;
		    int i=1;
		    while(i<=size){
		        sum+=i++;
		    }
		    while(size-->1){
		        sum=sum-sc.nextInt();
		    }
		    System.out.println(sum);
		}
	}
}