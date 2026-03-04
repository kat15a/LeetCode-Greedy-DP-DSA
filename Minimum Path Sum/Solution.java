class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 0, grid, dp);
    }

    private int helper(int i, int j, int[][] grid, int[][] dp) {

        int n = grid.length;
        int m = grid[0].length;

        if(i >= n || j >= m) return (int)1e9;

        if(i == n-1 && j == m-1)
            return grid[i][j];

        if(dp[i][j] != -1)
            return dp[i][j];

        int right = helper(i, j+1, grid, dp);
        int down = helper(i+1, j, grid, dp);

        dp[i][j] = grid[i][j] + Math.min(right, down);

        return dp[i][j];
    }
}
