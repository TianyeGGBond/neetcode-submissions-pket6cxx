class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++){
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        for (int j = 0 ; j < t.length(); j++){
            char cur = t.charAt(j);
            if (!map.containsKey(cur)) return false;
            map.put(cur, map.get(cur) - 1);
            if(map.get(cur) <= 0) map.remove(cur);
        }

        return map.isEmpty() ? true : false;
    }
}
