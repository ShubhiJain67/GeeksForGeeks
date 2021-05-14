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
		    int mask=1;
		    int count=0;
		    while(num!=0){
		        if((num&mask)!=0)
		            count++;
		        num=num>>>1;
		    }
		    System.out.println(count);
		}
	}

}