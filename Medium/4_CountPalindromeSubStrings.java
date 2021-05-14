class CountPalindromeSubStrings {
	public static void main (String[] args) {
            String str="abaab";
            int len=str.length();
		    System.out.println(count(str,len));
	}
	private static int count(String str,int len){
	    int ans=0;
	    boolean dp[][]=new boolean[len][len];
	    for(int gap=0;gap<len;gap++){
	        for(int i=0;i+gap<len;i++){
	            int j=i+gap;
	            if(gap==0)
	                dp[i][j]=true;
	            else if(gap==1 && str.charAt(i)==str.charAt(j))
	                dp[i][j]=true;
	            else if(gap>1){
	                if(str.charAt(i)==str.charAt(j))
	                    dp[i][j]=dp[i+1][j-1];
	                else
	                    dp[i][j]=false;
	            }
	            if(gap>0 && dp[i][j]){
                    System.out.println(str.substring(i, j+1));
                    ans++;
                }
	        }
	    }
	    return ans;
	}
}