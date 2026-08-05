class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];

        int diff = stone(stoneValue, 0, dp);

        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }

    private int stone(int[] stoneValue, int i, Integer[] dp) {
        if (i >= stoneValue.length)
            return 0;

        if (dp[i] != null)
            return dp[i];

        int take = 0;
        int ans = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {
            take += stoneValue[i + k];
            ans = Math.max(ans, take - stone(stoneValue, i + k + 1, dp));
        }

        return dp[i] = ans;
    }
}
