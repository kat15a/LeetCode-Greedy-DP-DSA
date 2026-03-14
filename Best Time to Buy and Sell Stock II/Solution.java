class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,1,prices,dp);
    }
    private int helper(int id,int buy,int[] prices,int[][] dp){
        int n=prices.length;
        if(id==n)return 0;
        if(dp[id][buy]!=-1)return dp[id][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[id]+helper(id+1,0,prices,dp),helper(id+1,1,prices,dp));
        }
        else{
            profit=Math.max(prices[id]+helper(id+1,1,prices,dp),0+helper(id+1,0,prices,dp));
        }
        return dp[id][buy]=profit;
    }
}
