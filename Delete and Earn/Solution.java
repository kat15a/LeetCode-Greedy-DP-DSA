class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        for(int x : nums) max = Math.max(max, x);

        int[] points = new int[max + 1];
        for(int x : nums){
            points[x] += x;
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);

        return helper(0, points, dp);
    }

    private int helper(int i, int[] points, int[] dp){

        if(i >= points.length) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = points[i] + helper(i + 2, points, dp);
        int notPick = helper(i + 1, points, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}
