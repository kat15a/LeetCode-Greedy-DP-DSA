class Solution {

    public boolean canPartition(int[] nums) {

        int total = 0;

        for (int x : nums) total += x;

        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = nums.length;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return subset(nums, n - 1, target, dp);
    }

    private boolean subset(int[] nums, int i, int target, int[][] dp) {

        if (target == 0) return true;

        if (i < 0) return false;

        if (dp[i][target] != -1)
            return dp[i][target] == 1;

        boolean notPick = subset(nums, i - 1, target, dp);

        boolean pick = false;

        if (nums[i] <= target)
            pick = subset(nums, i - 1, target - nums[i], dp);

        boolean ans = pick || notPick;

        dp[i][target] = ans ? 1 : 0;

        return ans;
    }
}
