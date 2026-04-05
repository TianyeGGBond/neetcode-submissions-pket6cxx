class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m+n != s3.length()) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] =true;

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i-1 >= 0 && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    dp[i][j] = dp[i-1][j] || dp[i][j];
                }
                if(j-1 >= 0 && s2.charAt(j-1) == s3.charAt(i+j-1)){
                     dp[i][j] = dp[i][j - 1] || dp[i][j];
                }
                System.out.println(dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
