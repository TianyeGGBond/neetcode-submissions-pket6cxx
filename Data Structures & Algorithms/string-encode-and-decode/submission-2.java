class Solution {

    public String encode(List<String> strs) {
        //n#strn#str
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int n = str.length();
            sb.append(String.valueOf(n)).append('.').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int n = str.length();
        StringBuilder num = new StringBuilder();

        int i = 0;

        while(i < n){
            char cur = str.charAt(i);
            if(cur != '.') {
                num.append(cur);
                i++;
            }else{
                String temp = num.toString();
                int j = Integer.parseInt(temp);
                res.add(str.substring(i+1,i+j+1));
                i = i+j+1;
                num.setLength(0);
            }
        }

        return res;
    }
}
