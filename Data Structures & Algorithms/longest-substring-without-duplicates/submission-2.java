class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0, r = 0;
        HashSet<Character> set = new HashSet<>();

        while(r < s.length()){
            if(!set.contains(s.charAt(r))){
                int temp = r-l+1;
                res = Math.max(res, temp);
            }else{
                while(set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            r++;
        }

        return res;
    }
}
