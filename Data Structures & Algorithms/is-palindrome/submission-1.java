class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if( s.trim().length() == 0) return true;
        //regulate string
        s = s.toLowerCase();
        List<Character> arr = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c) && !Character.isLetter(c)) continue;
            arr.add(c);
        }
        //iterate
        int l = 0;
        int r = arr.size()-1;
        //create two poniters
        while(l <= r){
            if (arr.get(l) != arr.get(r)) return false;
            l++;
            r--;
        }
        //end
        return true;
    }
}
