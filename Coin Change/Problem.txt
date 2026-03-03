class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = helper(n - 1, amount, coins, dp);

        if (ans >= 1e9) return -1;
        return ans;
    }

    private int helper(int idx, int amount, int[] coins, int[][] dp) {
        if (idx == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int)1e9;
        }

        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int notPick = helper(idx - 1, amount, coins, dp);
        int pick = (int)1e9;
        if (coins[idx] <= amount) {
            pick = 1 + helper(idx, amount - coins[idx], coins, dp);
        }

        return dp[idx][amount] = Math.min(pick, notPick);
    }
}
