class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i]-1,0)+1);
            System.out.println(map.get(nums[i]));
        }

        int max_len = 0;
        for(int n: map.values()){
            if(n > max_len){
                max_len = n;
            }
        }
        return max_len;

    }
}
