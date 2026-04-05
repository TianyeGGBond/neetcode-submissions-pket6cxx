class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return -1;

        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                int cur = coins[j];
                if(i - cur >= 0) dp[i] = Math.min(dp[i], dp[i-cur] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
