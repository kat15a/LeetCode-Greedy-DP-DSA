class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int n=words.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,-1,words,dp);
    }
    int helper(int i,int prev,String[] words,int[][] dp){
        int n=words.length;
        if(i==n)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int nottake=0+helper(i+1,prev,words,dp);
        int take=0;
        if(prev==-1 || predecessor(words[prev],words[i])){
            take=1+helper(i+1,i,words,dp);
        }
        return dp[i][prev+1]=Math.max(take,nottake);
    }
    boolean predecessor(String s1,String s2){
        if(s2.length()-s1.length()!=1)return false;
        int i=0;
        int j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i==s1.length();
    }
}
