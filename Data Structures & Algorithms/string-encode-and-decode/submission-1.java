class Solution {
    String str;
    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String st : strs){
            s.append(String.valueOf(st.length()) + "#" + st);
        }
        str = s.toString();
        return str;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while( i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len =Integer.parseInt(str.substring(i,j));
            j++;
            res.add(str.substring(j, j+len));
            i = j+len;
        }
        return res;
    }
}
