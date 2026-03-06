import java.util.*;

class Solution {

    public List<List<Integer>> generate(int numRows) {

        int[][] dp = new int[numRows][numRows];

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < numRows; r++) {

            List<Integer> row = new ArrayList<>();

            for (int c = 0; c <= r; c++) {

                row.add(pascal(r, c, dp));
            }

            result.add(row);
        }

        return result;
    }

    private int pascal(int r, int c, int[][] dp) {

        if (c == 0 || r == c) return 1;

        if (dp[r][c] != 0) return dp[r][c];

        return dp[r][c] =
                pascal(r - 1, c - 1, dp) +
                pascal(r - 1, c, dp);
    }
}
