class Solution {
    public int maximumAmount(int[][] coins) {
        int n=coins[0].length;
        int m=coins.length;
        Integer[][][] dp=new Integer[n+1][m+1][3];
        return helper(coins, 0, 0, 2,dp); 
    }

    private int helper(int[][] coins, int i, int j, int k,Integer[][][] dp) {
        int m = coins.length;
        int n = coins[0].length;
        if (i >= m || j >= n) return Integer.MIN_VALUE;
        if(dp[i][j][k]!=null)return dp[i][j][k];
        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && k > 0) return 0;
            return coins[i][j];
        }

        int right = helper(coins, i, j + 1, k,dp);
        int down = helper(coins, i + 1, j, k,dp);

        int best = Math.max(right, down);
        int take = coins[i][j] + best;
        int skip = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && k > 0) {
            int r = helper(coins, i, j + 1, k - 1,dp);
            int d = helper(coins, i + 1, j, k - 1,dp);
            skip = Math.max(r, d);
        }

        return dp[i][j][k]=Math.max(take, skip);
    }
}
