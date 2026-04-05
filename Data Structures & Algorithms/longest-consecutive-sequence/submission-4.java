class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int n = 0;

        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(i - 1 >= 0 && cur == nums[i-1]) continue;
            n++;
            
            if(i - 1 >= 0 && nums[i -1] != cur -1){
                n--;
                res = Math.max(n, res);
                n = 1;
            }
        }
        res = Math.max(n, res);
        return res;
    }
}
