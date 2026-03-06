class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]= Integer.MAX_VALUE;
            }
        }
      
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col<n; col++){
            ans = Math.min(ans, path(grid,0,col,dp));
        }
        return ans;
        
    }
    private int path(int[][] grid,int row,int col,int[][] dp){
        int n =grid.length;
        if(col == n || col<0) return Integer.MAX_VALUE;
        if(row == n-1) return grid[row][col];
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
        int result=Integer.MAX_VALUE;
        for (int nextCol = 0; nextCol < n; nextCol++) {
            if (nextCol == col) continue;
            result=Math.min(result,path(grid, row+1, nextCol, dp));
        }

    return dp[row][col] = grid[row][col] +result;
    }
}
