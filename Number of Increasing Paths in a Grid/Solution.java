class Solution {

    int MOD = 1_000_000_007;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int countPaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        long ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(grid, i, j, dp)) % MOD;
            }
        }

        return (int) ans;
    }

    private int dfs(int[][] grid, int r, int c, int[][] dp) {

        if (dp[r][c] != 0)
            return dp[r][c];

        int m = grid.length;
        int n = grid[0].length;

        long paths = 1;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                grid[nr][nc] > grid[r][c]) {

                paths = (paths + dfs(grid, nr, nc, dp)) % MOD;
            }
        }

        dp[r][c] = (int) paths;
        return dp[r][c];
    }
}
