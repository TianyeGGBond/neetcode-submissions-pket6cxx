class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if (map.containsKey(n)){
                int j = map.get(n);
                return i < j ? new int[]{i , j} : new int[]{j , i};
            }
            map.put(target-n, i);
        }
        return null;
    }
}
