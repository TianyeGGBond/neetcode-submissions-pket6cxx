class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c-'a', map.getOrDefault(c-'a', 0) + 1);
        }
        for(char c : t.toCharArray()){
            map.put(c-'a', map.getOrDefault(c-'a', 0) - 1);
            if(map.get(c-'a') == 0) map.remove(c-'a');
        }
        return map.keySet().size() == 0;
    }
}
