class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;

        int maxPre = 1;
        int minPre = 1;
        for(int i = 1; i<=n; i++){
            int tempMax = maxPre;
            int tempMin = minPre;
            maxPre = Math.max(nums[i-1], 
                Math.max(tempMax * nums[i-1], tempMin * nums[i-1]));
            
            minPre = Math.min(nums[i-1], 
                Math.min(tempMax * nums[i-1], tempMin * nums[i-1]));

            res = Math.max(res, maxPre);
        }
        return res;
    }
}
