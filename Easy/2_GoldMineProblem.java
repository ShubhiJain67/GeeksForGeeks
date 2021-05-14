public class GoldMine {
    public static void main(String[] args) {
        int maze[][]={{1, 3, 1, 5},{2, 2, 4, 1},{5, 0, 2, 3},{0, 6, 1, 2}};
        int n=maze.length,m=maze[0].length;
        memo=new int[n][m];
        for(int i=0;i<memo.length;i++)
            for(int j=0;j<memo[0].length;j++)
                memo[i][j]=Integer.MIN_VALUE;
        System.out.println(mine(maze));
        System.out.println(mineMemo(maze));
        System.out.println(mineDP(maze));
        System.out.println(mine2Array(maze));
    }
    
    private static int mine(int maze[][]){
        int ans=0;
        for(int i=0;i<maze.length;i++){
            ans=Math.max(ans,mineCall(maze,i,0,maze.length,maze[0].length));
        }
        return ans;
    }
    
    private static int mineCall(int maze[][],int si,int sj,int n,int m){
        if(sj==m-1)
            return maze[si][sj];
        int val=mineCall(maze,si,sj+1,n,m);
        if(si-1>=0)
            val=Math.max(val,mineCall(maze,si-1,sj+1,n,m));            
        if(si+1<n)
            val=Math.max(val,mineCall(maze,si+1,sj+1,n,m));
        val+=maze[si][sj];
        return val;
    }
    
    private static int memo[][];
    
    private static int mineMemo(int maze[][]){
        int ans=0;
        for(int i=0;i<maze.length;i++){
            ans=Math.max(ans,mineMemoCall(maze,i,0,maze.length,maze[0].length));
        }
        return ans;
    }
    
    private static int mineMemoCall(int maze[][],int si,int sj,int n,int m){
        if(memo[si][sj]!=Integer.MIN_VALUE)
            return memo[si][sj];
        if(sj==m-1){
            memo[si][sj]=maze[si][sj];
            return maze[si][sj];
        }
        int val=memo[si][sj+1]!=Integer.MIN_VALUE?memo[si][sj+1]:mineMemoCall(maze,si,sj+1,n,m);
        if(si-1>=0)
            val=Math.max(val,memo[si-1][sj+1]!=Integer.MIN_VALUE?memo[si-1][sj+1]:mineMemoCall(maze,si-1,sj+1,n,m));
        if(si+1<n)
            val=Math.max(val,memo[si+1][sj+1]!=Integer.MIN_VALUE?memo[si+1][sj+1]:mineMemoCall(maze,si+1,sj+1,n,m));
        memo[si][sj]=val+maze[si][sj];
        return memo[si][sj];
    }

    private static int mineDP(int maze[][]){
        int n=maze.length,m=maze[0].length,ans=0;
        int dp[][]=new int[n][m];
        for(int j=m-1;j>=0;j--){
            for(int i=0;i<n;i++){
                if(j==m-1)
                    dp[i][j]=maze[i][j];
                else{
                    dp[i][j]=dp[i][j+1];
                    if(i-1>=0)
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j+1]);
                    if(i+1<n)
                        dp[i][j]=Math.max(dp[i][j],dp[i+1][j+1]);
                    dp[i][j]+=maze[i][j];
                }
                if(j==0){
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }

    private static int mine2Array(int maze[][]){
        int n=maze.length,m=maze[0].length,ans=0;
        int dp1[]=new int[n];
        int dp2[]=new int[n];
        for(int j=m-1;j>=0;j--){
            for(int i=0;i<n;i++){
                if(j==m-1)
                    dp1[i]=maze[i][j];
                else{
                    dp1[i]=dp2[i];
                    if(i-1>=0)
                        dp1[i]=Math.max(dp1[i],dp2[i-1]);
                    if(i+1<n)
                        dp1[i]=Math.max(dp1[i],dp2[i+1]);
                    dp1[i]+=maze[i][j];
                }
                if(j==0){
                    ans=Math.max(ans,dp1[i]);
                }
            }
            dp2=dp1;
            dp1=new int[n];
        }
        return ans;
    }
}
