class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n];
        for (int i = 0; i <=amount; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n - 1, amount, coins, dp);
    }

    private int helper(int idx, int amount, int[] coins, int[][] dp) {
        if (idx == 0) {
            if (amount % coins[0] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[amount][idx] != -1)
            return dp[amount][idx];
        int notPick = helper(idx - 1, amount, coins, dp);
        int pick = 0;
        if (coins[idx] <= amount) {
            pick = helper(idx, amount - coins[idx], coins, dp);
        }
        dp[amount][idx] = pick + notPick;
        return dp[amount][idx];
    }
}
