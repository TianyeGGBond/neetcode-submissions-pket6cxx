class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(map.containsKey(n)){
                res[0] = map.get(n);
                res[1] = i;
                return res;
            }
            map.put(target - n, i);
        }
        return res;
    }
}
