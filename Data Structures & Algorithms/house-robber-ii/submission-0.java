class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        boolean firstSelect = false;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for(int i = 2; i < nums.length; i++){
            if(i == 2){
                dp[i] = nums[0];
            }
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        int recordF = dp[nums.length - 1];

        Arrays.fill(dp, 0);

        for(int i = 2; i <= nums.length; i++){
            if(i == 2){
                dp[i] = nums[1];
            }
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        int recordS = dp[nums.length];
        return recordF > recordS ? recordF : recordS;
    }
}
