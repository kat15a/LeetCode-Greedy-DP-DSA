class Solution {
    int max = 0;

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                helper(i, j, matrix);
            }
        }
        return max * max;
    }

    private int helper(int i, int j, char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (i >= n || j >= m) return 0;

        int right = helper(i, j + 1, matrix);
        int down = helper(i + 1, j, matrix);
        int diagonal = helper(i + 1, j + 1, matrix);

        if (matrix[i][j] == '1') {
            int ans = 1 + Math.min(diagonal, Math.min(right, down));
            max = Math.max(max, ans);
            return ans;
        } else {
            return 0;
        }
    }
}
