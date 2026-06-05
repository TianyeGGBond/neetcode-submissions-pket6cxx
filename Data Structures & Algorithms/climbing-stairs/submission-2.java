class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int cur = 0;
        
        for(int i = 3; i <= n; i++){
            cur = oneStepBefore + twoStepBefore;

            twoStepBefore = oneStepBefore;
            oneStepBefore = cur;
        }
        return cur;
    }
}
