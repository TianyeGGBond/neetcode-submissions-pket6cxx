class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        Arrays.sort(coins);

        //min coin to amount i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = coins.length - 1 ; j >= 0; j--){
                if (i - coins[j] >= 0){
                    if(dp[i - coins[j]] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
