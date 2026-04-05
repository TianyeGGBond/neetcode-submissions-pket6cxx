class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        
        int max = 0;
        for(int x : set){
            if(!set.contains(x-1)){
                int cur = x;
                int len = 1;
                while(set.contains(cur+1)){
                    cur++;
                    len++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
        
    }
}
