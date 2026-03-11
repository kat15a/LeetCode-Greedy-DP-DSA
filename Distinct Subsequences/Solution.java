class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,s,t,dp);
    }
    private int helper(int i,int j,String s, String t,int[][] dp){
        int n=s.length();
        int m=t.length();
        if(j==m)return 1;
        if(i==n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=helper(i+1,j+1,s,t,dp)+helper(i+1,j,s,t,dp);
        }
        else{
            return dp[i][j]=helper(i+1,j,s,t,dp);
        }
    }
}
