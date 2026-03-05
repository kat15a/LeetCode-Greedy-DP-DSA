class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return Math.min(stairs(cost, n - 1, dp), stairs(cost, n - 2, dp));
    }

    private int stairs(int[] cost, int n, int[] dp) {

        if (n == 0) return cost[0];

        if (n == 1) return cost[1];

        if (dp[n] != -1) return dp[n];

        return dp[n] = cost[n] + Math.min(
                stairs(cost, n - 1, dp),
                stairs(cost, n - 2, dp)
        );
    }
}
