class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Integer[][] dp=new Integer[nums1.length][nums2.length];
        return helper(0,0,nums1,nums2,dp);
    }
    private int helper(int i,int j,int[] nums1,int[] nums2,Integer[][] dp){
        int n=nums1.length;
        int m=nums2.length;
        if(i==n || j==m )return 0;
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(nums1[i]==nums2[j]){
            return dp[i][j]=1+helper(i+1,j+1,nums1,nums2,dp);
        }
        else{
            int x=helper(i+1,j,nums1,nums2,dp);
            int y=helper(i,j+1,nums1,nums2,dp);
            return dp[i][j]=Math.max(x,y);
        }
         
    }
}
