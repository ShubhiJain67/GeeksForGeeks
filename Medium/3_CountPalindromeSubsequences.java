class GfG
{
    int countPS(String str)
    {
            return longestIter(str);
    }
    private int longestIter(String str){
        int n=str.length(),dp[][]=new int[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                int j=i+gap;
                if(gap==0)
                    dp[i][j]=1;
                else{
                    dp[i][j]=dp[i+1][j]+dp[i][j-1];
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j]+=1;
                    }else if(gap>1){
                        dp[i][j]-=dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}