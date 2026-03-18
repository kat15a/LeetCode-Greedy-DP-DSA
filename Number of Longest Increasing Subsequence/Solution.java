
class Solution {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];      
        int[] count = new int[n];

        Arrays.fill(dp, -1);

        int maxLen = 0;

        for(int i = 0; i < n; i++){
            int len = helper(i, nums, dp, count);
            maxLen = Math.max(maxLen, len);
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            if(dp[i] == maxLen){
                ans += count[i];
            }
        }

        return ans;
    }

    private int helper(int i, int[] nums, int[] dp, int[] count){

        if(dp[i] != -1) return dp[i];

        int maxLen = 1;
        int ways = 1;

        for(int j = 0; j < i; j++){

            if(nums[i] > nums[j]){

                int len = 1 + helper(j, nums, dp, count);

                if(len > maxLen){
                    maxLen = len;
                    ways = count[j];
                }
                else if(len == maxLen){
                    ways += count[j];
                }
            }
        }

        dp[i] = maxLen;
        count[i] = ways;

        return dp[i];
    }
}
