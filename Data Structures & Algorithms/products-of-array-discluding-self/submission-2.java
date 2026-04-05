class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] front = new int[n];
        int[] back = new int[n];

        //product of all elements to the left of nums[i]
        front[0] = 1;
        back[n-1] = 1;

        for(int i = 1; i < n; i++){
            front[i] = nums[i-1] * front[i-1];
            back[n-1-i] = nums[n-i] * back[n-i];
        }

        int[] res = new int[n];

        for(int i = 0; i < n ; i++){
            res[i] = back[i] * front[i];
        }

        return res;
    }
}  
