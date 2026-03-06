class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]= Integer.MAX_VALUE;
            }
        }
      
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col<n; col++){
            ans = Math.min(ans, path(matrix,0,col,dp));
        }
        return ans;
        
    }
    private int path(int[][] matrix,int row,int col,int[][] dp){
        int n = matrix.length;
        if(col == n || col<0) return Integer.MAX_VALUE;
        if(row == n-1) return matrix[row][col];
        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];
    int below= path(matrix,row+1,col,dp);
    int right=path(matrix,row+1,col+1,dp);
    int left=path(matrix,row+1,col-1,dp);
    return dp[row][col] =  matrix[row][col] + Math.min(below,Math.min(right,left));
    }
}
