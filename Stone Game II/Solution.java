class Solution {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][n + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solveAlice(piles, 1, 0, 1, dp);
    }

    private int solveAlice(int[] piles, int person, int i, int M, int[][][] dp) {
        int n = piles.length;

        if (i >= n)
            return 0;

        if (dp[i][M][person] != -1)
            return dp[i][M][person];

        int stones = 0;
        int result = (person == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];

            if (person == 1) {
                result = Math.max(
                        result,
                        stones + solveAlice(piles, 0, i + x, Math.max(M, x), dp));
            } else {
                result = Math.min(
                        result,
                        solveAlice(piles, 1, i + x, Math.max(M, x), dp));
            }
        }

        return dp[i][M][person] = result;
    }
}
