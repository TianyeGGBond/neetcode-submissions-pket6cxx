class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i<= n;i++){
            for(String w : wordDict){
                int wLen = w.length();
                if(i - wLen >= 0 && s.substring(i-wLen, i).equals(w)){
                    dp[i] = dp[i] || dp[i - wLen];
                    if(dp[i]) break;
                }
            }
        }
        return dp[n];
    }
}
