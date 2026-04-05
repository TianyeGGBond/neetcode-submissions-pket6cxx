class Solution {
    int count = 0;
    public int numDecodings(String s) {
        if(s == null || s == "") return 0;
        dfs(0,s);
        return count;
    }
    private void dfs(int start, String s){
        if(start == s.length()) {
            count++;
            return;
        }
        //最多两位 && i < start + 2
        for(int i = start; i < s.length() && i < start + 2; i++){
            if(isValid(s.substring(start, i+1))){
                dfs(i+1, s);
            }
        }
    }

    private boolean isValid(String x){
        if(x == null || x.length() == 0) return false;

        if(x.charAt(0) == '0') return false;

        int num = Integer.parseInt(x);
        if (num > 0 && num < 27) return true;
        return false;
    }
}