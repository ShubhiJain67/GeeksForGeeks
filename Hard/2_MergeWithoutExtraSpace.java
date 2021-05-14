//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int gap = n + m;
        gap = (gap / 2) + (gap % 2);
        int pointer1 = 0;
        int pointer2 = 0;
        while (gap > 0) {
        // Setting pointers
            pointer1 = 0;
            pointer2 = gap < n ? gap : gap - n;
            
            //Both the pointers are in the firt arrays
            if (gap < n) {
                while (pointer1 < n && pointer2 < n) {
                    check(arr1, arr1, pointer1, pointer2);
                    pointer1++;
                    pointer2++;
                }
            }
    
            //Setting pointer2 at the start of second array
            if(pointer2 == n){
                pointer2 = 0;
            }
    
            //While pointer1 is in first array and pointer 2 is in second array
            while (pointer1 < n && pointer2 < m) {
                check(arr1, arr2, pointer1, pointer2);
                pointer1++;
                pointer2++;
            }
    
            //Setting pointer1 at the start of second array
            if(pointer1 == n){
                pointer1 = 0;
            }
    
            //While pointer1 and pointer 2 are in second array
            while (pointer1 < m && pointer2 < m) {
                check(arr2, arr2, pointer1, pointer2);
                pointer1++;
                pointer2++;
            }
            if(gap == 1){
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
        
    }
    public static void check(long arr1[],long arr2[],int pointer1,int pointer2){
        if(arr1[pointer1]>arr2[pointer2]){
            long temp=arr1[pointer1];
            arr1[pointer1]=arr2[pointer2];
            arr2[pointer2]=temp;
        }
    }
}
