
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int testCases=sc.nextInt();
		while(testCases-->0){
		    int num=sc.nextInt();
		    System.out.println(Count(num));
		}
	}
	private static int Count(int num){
	    int count=0;
	    do{
	        int log=(int)(Math.log(num+1) / Math.log(2));
    	    int pow=(int)Math.pow(2,log-1);
    	    count+=pow*log;
    	    num=num-(pow<<1);
    	    count+=num+1;
	    }while(num>0);
	    return count;
	}
}