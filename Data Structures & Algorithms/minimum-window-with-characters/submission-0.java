class Solution {
    public String minWindow(String s, String t) {
        //need size
        Map<Character,Integer> need = new HashMap<>();
        for(char ch : t.toCharArray()){
            need.put(ch, need.getOrDefault(ch,0)+1);
        }
        int ans = need.keySet().size();


        int len = Integer.MAX_VALUE;
        String res = "";

        Map<Character,Integer> good = new HashMap<>();
        int l = 0;
        int correct = 0;
        for(int r = 0; r < s.length(); r++){

            if(need.containsKey(s.charAt(r))){
                good.put(s.charAt(r), good.getOrDefault(s.charAt(r), 0) +1);
                if(good.get(s.charAt(r)) == need.get(s.charAt(r))) correct++;
            }

            while(correct == ans){
                if(r-l+1< len){
                len = r-l+1;
                res = s.substring(l,r+1);
                }

                if(need.containsKey(s.charAt(l))) {
                    char cur = s.charAt(l);
                    good.put(cur, good.get(cur)-1);
                    if(good.get(cur) == need.get(cur)-1) correct--;
                }
                l++;
            }
        }
        return res;
    }
}
