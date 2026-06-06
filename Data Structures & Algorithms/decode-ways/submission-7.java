class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int twoStepBf = 1;
        int oneStepBf = s.charAt(0) == '0'? 0 : 1;

        for(int i = 2; i <= n; i++){
            int cur = 0;
            if(s.charAt(i-1) != '0'){
                cur += oneStepBf;
            }

            int two = Integer.parseInt(s.substring(i-2, i));
            if(s.charAt(i-2) != '0' && two >= 10 && two <= 26){
                cur += twoStepBf;
            }
            twoStepBf = oneStepBf;
            oneStepBf = cur;
        }
        return oneStepBf;
    }
}
