class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<Integer>[][] dp=new ArrayList[n+1][n+1];
        return helper(0,-1,nums,dp);
    }

    private List<Integer> helper(int id, int prev, int[] nums,List<Integer>[][] dp) {
        int n=nums.length;
        if (id == n)
            return new ArrayList<>();
        if(dp[id][prev+1] != null)return dp[id][prev+1];
        List<Integer> nottake = helper(id + 1,prev, nums,dp);
        List<Integer> take = new ArrayList<>();
        if (prev==-1 || nums[id]%nums[prev]==0 ) {
            take = new ArrayList<>(helper(id + 1, id, nums,dp));
            take.add(nums[id]);
        }
        if(nottake.size()>take.size()){
            return dp[id][prev+1]=nottake;
        }
        else{
            return dp[id][prev+1]=take;
        }

    }
}
