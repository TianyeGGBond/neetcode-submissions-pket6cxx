class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int nextEnd = 0;
        int curEnd = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            nextEnd = Math.max(nextEnd, i + nums[i]);
            if(i == curEnd){
                jump++;
                curEnd = nextEnd;
            }
        }
        return jump;
    }
}
