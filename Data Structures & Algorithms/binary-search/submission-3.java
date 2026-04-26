class Solution {
    public int search(int[] nums, int target) {
        //找target 找到返回
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid =l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid -1;
            }
        }
        return -1;

        //找第一个大于target的数，重复元素中l-1就是最后一个数 l-1 = tar_index
        //如果target不存在 l就是插入target的地方
        // nums[m] >= target 则会找重复元素的第一个 l = tar_index
        // 如果存在就是 = tar_index
        // 如果不存在 nums[m] > target 就是同上
        // [1, 2, 2, 2, 5, 7]
        //     ^        ^
            // lower    upper
        // int l = 0, r = nums.length;

        // while (l < r) {
        //     int m = l + ((r - l) / 2);
        //     if (nums[m] > target) {
        //         r = m;
        //     } else {
        //         l = m + 1;
        //     }
        // }
        // return (l > 0 && nums[l - 1] == target) ? l - 1 : -1;
    }
}
