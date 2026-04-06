class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] arr_tar = new int[26];
        int[] arr_find = new int[26];
        int n = s1.length();

        for(char c : s1.toCharArray()){
            arr_tar[c - 'a']++;
        }

        int l = 0;

        for(int r = 0; r < s2.length(); r++){
            arr_find[s2.charAt(r) - 'a']++;

            while(r-l+1 < n && r < s2.length()){
                r++;
                arr_find[s2.charAt(r) - 'a']++;
            }

            if(r-l+1 > n){
                arr_find[s2.charAt(l) - 'a']--;
                l++;
            }

            if(r-l+1 == n && Arrays.equals(arr_tar, arr_find)) return true;
        }

        return false;
    }
}
