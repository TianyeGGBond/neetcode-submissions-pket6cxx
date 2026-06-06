class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int sum = 0;
        int res = Integer.MIN_VALUE;

        for(int num : nums){
            sum = Math.max(num, sum + num);
            res = Math.max(res, sum);
        }

        return res;

    }
}
