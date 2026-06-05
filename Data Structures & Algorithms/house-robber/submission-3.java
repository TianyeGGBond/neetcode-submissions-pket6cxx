class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int twoStepBefore = nums[0];
        int oneStepBefore = Math.max(nums[0], nums[1]);
        int cur = oneStepBefore;
        for(int i = 2; i < nums.length; i++){
            cur = Math.max(
                twoStepBefore + nums[i],
                oneStepBefore
            );
            twoStepBefore = oneStepBefore;
            oneStepBefore = cur;
        }
        return cur;
    }
}
