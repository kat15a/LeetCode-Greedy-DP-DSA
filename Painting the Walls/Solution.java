class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,n,cost,time,dp);
    }
    private int helper(int id,int wall,int[] cost,int[] time,int[][] dp){
        int n=cost.length;
        if(wall<=0)return 0;
        if(id==n)return (int)1e9;
        if(dp[id][wall]!=-1)return dp[id][wall];
        int notpick=helper(id+1,wall,cost,time,dp);
        int pick=cost[id]+helper(id+1,wall-1-time[id],cost,time,dp);
        return dp[id][wall]=Math.min(notpick,pick);
    }
}
