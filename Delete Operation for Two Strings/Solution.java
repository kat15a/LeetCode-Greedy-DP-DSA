class Solution {

    public int minDistance(String word1, String word2){
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(word1, word2, word1.length(), word2.length(),dp);
    }

    public int solve(String s1, String s2, int n, int m,int[][] dp) {
        if (n == 0) return m;
        if (m == 0) return n;
        if(dp[n][m]!=-1)return dp[n][m];
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m]=solve(s1, s2, n - 1, m - 1,dp);
        }
        int deleteFromS1 = solve(s1, s2, n - 1, m,dp);
        int deleteFromS2 = solve(s1, s2, n, m - 1,dp);

        return dp[n][m]=1 + Math.min(deleteFromS1, deleteFromS2);
    }
}
