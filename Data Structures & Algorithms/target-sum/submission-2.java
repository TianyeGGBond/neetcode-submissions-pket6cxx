class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((target + sum) % 2 != 0 || target + sum < 0) return 0;
        int temp = (target + sum) / 2;

        int[] dp = new int[temp + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int i = temp; i >= 0; i--){
                if(i - num >= 0) dp[i] += dp[i-num];
            }
        }
        return dp[temp];
    }
}
