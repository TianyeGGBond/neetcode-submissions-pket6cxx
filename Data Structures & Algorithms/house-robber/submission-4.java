class Solution {
    public int rob(int[] nums) {

        int twoStepBefore = 0;
        int oneStepBefore = 0;

        for(int num : nums){
            int cur = Math.max(twoStepBefore + num, oneStepBefore);
            twoStepBefore = oneStepBefore;
            oneStepBefore = cur;
        }
        return oneStepBefore;
    }
}
