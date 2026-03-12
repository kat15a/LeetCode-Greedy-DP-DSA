class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean[][] dp=new Boolean[n+1][m+1];
        return helper(0,0,s,p,dp);
    }
    private boolean helper(int i,int j,String s,String p,Boolean[][] dp){
        int n=s.length();
        int m=p.length();
        if(i==n&&j==m)return true;
        if(i<n && j==m)return false;
        if(dp[i][j]!=null)return dp[i][j];
        if(i==n && j<m){
            for(int k=j;k<m;k++){
                if(p.charAt(k)!='*')return dp[i][j]=false;
            }
            return dp[i][j]=true;

        }
        if(s.charAt(i)==p.charAt(j)|| p.charAt(j)=='?'){
            return dp[i][j]=helper(i+1,j+1,s,p,dp);
        }
        if(p.charAt(j)=='*'){
            return dp[i][j]=helper(i+1,j,s,p,dp)|| helper(i,j+1,s,p,dp);
        }
        else return dp[i][j]=false;
    }
}
