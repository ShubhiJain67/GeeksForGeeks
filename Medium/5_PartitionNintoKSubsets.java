public class PartitionNintoKSubsets {
    public static void main(String[] args) {
        int n=4,k=3;
        System.out.println(part(n,k));
        memo=new int[n+1][k+1];
        System.out.println(partMemo(n,k));
        System.out.println(partDP(n,k));
    }
    private static int part(int n,int k){
        if(n<k || n==0 || k==0)
            return 0;
        if(n==k || k==1)
            return 1;
        int formNew=part(n-1,k-1);
        int old=part(n-1,k)*k;
        return formNew+old;
    }
    private static int memo[][];
    private static int partMemo(int n,int k){
        if(n<k || n==0 || k==0)
            return 0;
        if(n==k || k==1)
            return 1;
        if(memo[n][k]!=0)
            return memo[n][k];
        int formNew=memo[n-1][k-1]==0?partMemo(n-1,k-1):memo[n-1][k-1];
        int old=(memo[n-1][k]==0?partMemo(n-1,k):memo[n-1][k])*k;
        memo[n][k]=formNew+old;
        return memo[n][k];
    }
    private static int partDP(int N,int K){
        int dp[][]=new int[N+1][K+1];
        for(int k=1;k<=K;k++){
            for(int n=1;n<=N;n++){
                if(n<k)
                    dp[n][k]=0;
                else if(k==1 || k==n)
                    dp[n][k]=1;
                else
                    dp[n][k]=dp[n-1][k-1]+dp[n-1][k]*k;
            }
        }
        return dp[N][K];
    }
}