class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l = 0;
        int[] freq = new int[26];
        int maxFreq = 0;

        for(int i = 0; i < s.length() ; i++){
            freq[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(i) - 'A']);

            if(i - l + 1 - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, i-l+1);
        }
        return res;
    }
}
