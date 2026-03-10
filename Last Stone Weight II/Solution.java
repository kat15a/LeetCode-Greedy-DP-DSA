import java.util.Arrays;

class Solution {

    public int lastStoneWeightII(int[] stones) {

        int total = 0;

        for (int s : stones) {
            total += s;
        }

        int[][] dp = new int[stones.length][total + 1];

        for (int i = 0; i < stones.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, stones, 0, total, dp);
    }

    private int helper(int i, int[] stones, int sum, int total, int[][] dp) {

        if (i == stones.length) {
            return Math.abs(total - 2 * sum);
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        int pick = helper(i + 1, stones, sum + stones[i], total, dp);

        int notPick = helper(i + 1, stones, sum, total, dp);

        return dp[i][sum] = Math.min(pick, notPick);
    }
}
