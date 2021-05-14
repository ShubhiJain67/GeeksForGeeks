// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    
 // } Driver Code Ends


//User function template for Java

public static void sort012(int a[], int n){
    // code here 
    int zero=0;
    int one=0;
    int two=0;
    for(int i:a){
        if(i==0)
            zero++;
        if(i==1)
            one++;
        if(i==2)
            two++;
    }
    int index=0;
    while(zero-->0){
        a[index++]=0;
    }
    while(one-->0){
        a[index++]=1;
    }
    while(two-->0){
        a[index++]=2;
    }
}

// { Driver Code Starts.

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends