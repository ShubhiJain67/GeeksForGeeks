
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class GFG {
	public static void main (String[] args) {
		//code
		Scanner s=new Scanner(System.in);
		int test=s.nextInt();
		TestCases(s,test);
	}
	
	public static void TestCases(Scanner s,int test){
	    while(test!=0){
	        BigInteger num=s.nextBigInteger();
	        System.out.println(ToAlpha(num));
	        test--;
	    }
	}
	public static String ToAlpha(BigInteger num){
	    String str="";
	    BigInteger zero=new BigInteger("0");
	     BigInteger one=new BigInteger("1");
	    BigInteger ts=new BigInteger("26");
	    while(num.compareTo(zero)!=0){
	        int rem=(num.mod(ts)).intValue();
	        if(rem!=0){
	        str=(char)(64+rem)+str;
	        num=num.divide(ts);
	        }
	        
	        else{
	            num=num.divide(ts);
	            num=num.subtract(one);
	            str='Z'+str;
	        }
	        
	    }
	    return str;
	}
}