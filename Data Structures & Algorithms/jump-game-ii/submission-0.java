class Solution {
    public int jump(int[] nums) {
        int curfar = 0;
        int curfarest = 0;
        int jump = 0;
        for(int i = 0; i < nums.length - 1; i++){
            curfarest = Math.max(curfarest, i + nums[i]);
            if( i == curfar){
                curfar = curfarest;
                jump++;
            }
        }
        return jump;
    }
}
