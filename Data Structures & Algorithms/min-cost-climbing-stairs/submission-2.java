class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int oneStepBefore = 0;
        int twoStepBefore = 0;
        int cur = 0;
        for(int i = 2; i <= cost.length; i++){
            cur = Math.min(
                oneStepBefore + cost[i-1], 
                twoStepBefore + cost[i-2]
            );
            twoStepBefore = oneStepBefore;
            oneStepBefore = cur;
        }
        return cur;
    }
}
