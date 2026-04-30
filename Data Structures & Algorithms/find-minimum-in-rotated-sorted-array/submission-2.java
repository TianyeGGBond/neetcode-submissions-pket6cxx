class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;

        // while(l <= r){
        //     int mid = l + (r - l ) / 2;
        //     if(nums[mid] > nums[r]){
        //         l = mid + 1;
        //     }else if(nums[mid] < nums[r]){
        //         r = mid;
        //     }else{
        //         return nums[mid];
        //     }
        // }
        // return 0;

        while(l < r){
            int mid = l + (r - l ) / 2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return nums[l];
    }
}
