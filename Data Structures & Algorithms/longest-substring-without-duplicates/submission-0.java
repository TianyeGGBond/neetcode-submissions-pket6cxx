class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int len = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r< n){
            while(r < n && !map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),0);
                len++;
                r++;
            }
            res = Math.max(len,res);

            while(l < r && r < n && s.charAt(r) != s.charAt(l)){
                map.remove(s.charAt(l));
                l++;
                len--;
            }

            if(l <n && r < n && s.charAt(r) == s.charAt(l)){
                map.remove(s.charAt(l));
                l++;
                len--;
            }
        }
        return res;
    }
}
