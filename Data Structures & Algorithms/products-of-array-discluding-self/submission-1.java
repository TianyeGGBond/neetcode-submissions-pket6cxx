class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] front = new int[n];
        int[] back = new int[n];

        front[0] = nums[0];
        back[n-1] = nums[n-1];

        for(int i = 1; i < n; i++){
            front[i] = nums[i] * front[i-1];
            back[n-1-i] = nums[n-1-i] * back[n-i];
        }

        int[] res = new int[n];

        for(int i = 0; i < n ; i++){
            if(i == 0) res[i] = back[1];
            else if(i == n - 1) res[i] = front[i-1];
            else res[i] = back[i+1] * front[i-1];
        }

        return res;
    }
}  
