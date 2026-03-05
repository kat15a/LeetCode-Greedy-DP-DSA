import java.util.Arrays;

class Solution {

    public long rob(int[] nums, int[] colors) {

        long[] dp = new long[nums.length];
        Arrays.fill(dp, -1);

        return solve(0, nums, colors, dp);
    }

    private long solve(int i, int[] nums, int[] colors, long[] dp) {

        if (i >= nums.length) return 0;

        if (dp[i] != -1) return dp[i];

        long take = nums[i];

        if (i < nums.length - 1 && colors[i] != colors[i + 1]) {
            take += solve(i + 1, nums, colors, dp);
        } else {
            take += solve(i + 2, nums, colors, dp);
        }

        long notTake = solve(i + 1, nums, colors, dp);

        return dp[i] = Math.max(take, notTake);
    }
}
