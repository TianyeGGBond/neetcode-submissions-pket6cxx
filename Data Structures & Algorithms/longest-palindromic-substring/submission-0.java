class Solution {
    public String longestPalindrome(String s) {
        int resIndex = 0;
        int resLen = 0;

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for(int i = len-1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j) &&
                ( j - i < 3 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j - i + 1 > resLen){
                    resIndex = i;
                    resLen = j - i + 1;
                }
                }
            }
        }
        return s.substring(resIndex, resIndex + resLen);
    }
}
