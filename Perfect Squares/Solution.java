class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        return helper(n,dp);

    }

    private int helper(int n,int[] dp) {
        if (n == 0)return 0;
        if (dp[n]!= 0)return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int res = helper(n - i * i,dp);
            min = Math.min(min, res + 1);
        }
        dp[n]=min;
        return min;
    }
}
