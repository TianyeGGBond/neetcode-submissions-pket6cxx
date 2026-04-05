class Solution {
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int[] temp = new int[m + 2];
        temp[0] = 1;
        temp[m+1] = 1;
        for(int i = 0; i < m; i++){
            temp[i+1] = nums[i];
        }
        int[][] dp = new int[m + 2][m + 2];

        for(int len = 2; len < m + 2; len ++){
            for(int i = 0; i + len < m + 2; i++){
                int j = i + len;
                for(int k = i + 1; k < j; k++ ){
                    dp[i][j] = Math.max(dp[i][j],
                    dp[i][k] + dp[k][j] + temp[i] * temp[j] * temp[k]);
                }
                System.out.println(dp[i][j]);
            }
        }
        return dp[0][m + 1];
    }
}
