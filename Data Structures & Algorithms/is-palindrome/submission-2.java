class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        //create 2 pointers
        int l = 0;
        int r = s.length() - 1;
        //check if d/l, check if the same
        //when it's valid, and situation l = r dont need to check
        while(l<r){
            //pointer passes all non-valid chars
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            //check whether they are same
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;

            //move pointers
            l++;
            r--;
        }
        //pass all
        return true;
    }
}
