import java.util.Arrays;

class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums, target);
    }

    public int countPartitions(int[] nums, int target) {

        int total = 0;
        for (int x : nums) total += x;

        if (total + target < 0) return 0;

        if ((total + target) % 2 != 0) return 0;

        int tar = (total + target) / 2;

        int n = nums.length;
        int[][] dp = new int[n][tar + 1];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return helper(n - 1, nums, tar, dp);
    }

    private int helper(int id, int[] nums, int target, int[][] dp) {

        if (id == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || nums[0] == target) return 1;
            return 0;
        }

        if (dp[id][target] != -1) return dp[id][target];

        int notpick = helper(id - 1, nums, target, dp);

        int pick = 0;
        if (nums[id] <= target)
            pick = helper(id - 1, nums, target - nums[id], dp);

        return dp[id][target] = pick + notpick;
    }
}
