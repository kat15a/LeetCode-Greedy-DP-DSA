class Solution {
    int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp=new Integer[n+1][target+1];
        return helper(n,k,target,dp);
    }
    private int helper(int n,int k,int target,Integer[][] dp){
        if(target<0)return 0;
        if(n==0 && target!=0)return 0;
        if(n!=0 && target==0)return 0;
        if(n==0 && target==0)return 1;
        if(dp[n][target]!=null)return dp[n][target];
        int ans=0;
        for(int i=1;i<=k;i++){
            ans=(ans+helper(n-1,k,target-i,dp))%MOD;
        }
        return dp[n][target]=(int)ans;
    }
}
