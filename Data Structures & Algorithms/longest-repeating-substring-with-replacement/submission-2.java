class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int max = 0;
        int l = 0;
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            int cur = s.charAt(i) - 'A';
            arr[cur] ++;
            max = Math.max(arr[cur], max);
            res = Math.max(max+k, res);
            if(i-l+1 > res){
                int pre = s.charAt(l) - 'A';
                arr[pre] --;
                l++;
            }
        }
        return res > s.length()? s.length() : res;
    }
}
