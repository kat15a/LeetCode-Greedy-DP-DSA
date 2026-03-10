import java.util.Arrays;

class Solution {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length][m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, strs, m, n, dp);
    }

    private int helper(int id, String[] strs, int m, int n, int[][][] dp) {

        if (id == strs.length)
            return 0;

        if (dp[id][m][n] != -1)
            return dp[id][m][n];

        int zero = 0, one = 0;

        for (char c : strs[id].toCharArray()) {
            if (c == '0') zero++;
            else one++;
        }

        int notPick = helper(id + 1, strs, m, n, dp);

        int pick = 0;
        if (zero <= m && one <= n) {
            pick = 1 + helper(id + 1, strs, m - zero, n - one, dp);
        }

        return dp[id][m][n] = Math.max(pick, notPick);
    }
}
