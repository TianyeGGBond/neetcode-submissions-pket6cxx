class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;

        while(l < r){
            int mid = l + (r - l)/ 2;
            if(nums[mid] <= nums[len - 1]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        // pivot == l
        int p = l;

        l = 0;
        r = len - 1;

        if (target >= nums[p] && target <= nums[len - 1]) {
            l = p;
        } else {
            r = p - 1;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;

    }
}
