class Solution {
    public boolean hasDuplicate(int[] nums) {
        // invalid input
        if(nums == null || nums.length == 0 ){
            return false;
        }

        // traversal
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            //System.out.println(set);
        }

        return false;
    }
}