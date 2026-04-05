class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
        
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = i; j >= 0 && j - i <= 19 ; j--){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
        
    }
}
