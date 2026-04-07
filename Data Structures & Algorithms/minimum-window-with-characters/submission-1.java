class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c , 0) + 1);
        }

        int count = 0 , l = 0;
        String res = s;
        boolean found = false;

        HashMap<Character, Integer> find = new HashMap<>();
        for(int r = 0; r < s.length(); r++){
            while((map.getOrDefault(s.charAt(l),-1) < find.getOrDefault(s.charAt(l), 0)) && l < r) {
                char lmax = s.charAt(l);
                if(find.containsKey(lmax)) find.put(lmax, find.getOrDefault(lmax, 0) -1 );
                l++;
            }

            char cur = s.charAt(r);
            if(map.containsKey(cur) ){
                find.put(cur, find.getOrDefault(cur, 0) + 1);
                if(find.get(cur) <= map.get(cur)) count++;
            }
            
            // satified substring, substract to not satified
            while(count == t.length()){
                found = true;
                char pre = s.charAt(l);

                //left nonsense
                if(!find.containsKey(pre)){
                    break;
                //left is in but none affect answer
                }else if(find.get(pre) > map.get(pre)){
                    find.put(pre, find.get(pre) - 1);
                //left matters
                }else{
                    find.put(pre, find.get(pre) - 1);
                    if(find.get(pre) == 0) find.remove(pre);
                    
                    //renew result if shorter
                    if(r-l+1 < res.length()) res = s.substring(l, r+1);
                    count--;
                }
                l++;                
            }
        }
        return found == true ? res : "";
    }
}
