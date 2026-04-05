class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;

        int len = nums.length;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = target; j > 0; j--){
                if(j - nums[i-1] >= 0){
                    dp[j] = dp[j] || dp[j - nums[i-1]];
                }
            }
        }
        return dp[target];

    }
}
