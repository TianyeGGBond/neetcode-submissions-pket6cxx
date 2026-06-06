class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }
    
    private int rob(int[] nums, int start, int end){
        if(end == start) return nums[start];

        int twoStepBf = nums[start];
        int oneStepBf = Math.max(nums[start], nums[start + 1]);

        for(int i = start + 2; i <= end; i++){
            int cur = Math.max(twoStepBf + nums[i], oneStepBf);
            twoStepBf = oneStepBf;
            oneStepBf = cur;
        }
        return oneStepBf;    
    }
}
