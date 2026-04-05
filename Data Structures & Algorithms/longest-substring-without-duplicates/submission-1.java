class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int l = 0;

        Set<Character> set = new HashSet<>();
        for(int r = 0; r < n; r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++; //也会出现l = r的情况，不过接下来会加上r合法
            }
            set.add(s.charAt(r));
            res = Math.max(res, r-l + 1);
        }
        return res;
    }
}
