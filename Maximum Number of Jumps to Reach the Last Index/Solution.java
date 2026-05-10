class Solution {

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -2);

        return solve(0, nums, target, dp);
    }

    private int solve(int i, int[] nums, int target, int[] dp) {

        int n = nums.length;
        if (i == n - 1) {
            return 0;
        }
        if (dp[i] != -2) {
            return dp[i];
        }

        int ans = -1;

        for (int j = i + 1; j < n; j++) {

            if (Math.abs(nums[j] - nums[i]) <= target) {

                int jump = solve(j, nums, target, dp);

                if (jump != -1) {
                    ans = Math.max(ans, 1 + jump);
                }
            }
        }

        return dp[i] = ans;
    }
}
