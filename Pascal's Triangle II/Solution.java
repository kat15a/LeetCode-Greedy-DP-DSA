class Solution {

    public List<Integer> getRow(int rowIndex) {

        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> row = new ArrayList<>();

        for (int c = 0; c <= rowIndex; c++) {
            row.add(pascal(rowIndex, c, dp));
        }

        return row;
    }

    private int pascal(int r, int c, int[][] dp) {

        if (c == 0 || c == r) return 1;

        if (dp[r][c] != 0) return dp[r][c];

        return dp[r][c] =
                pascal(r - 1, c - 1, dp) +
                pascal(r - 1, c, dp);
    }
}
