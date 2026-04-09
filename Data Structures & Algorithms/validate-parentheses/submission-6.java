class Solution {
    public boolean isValid(String s) {
        HashMap<Character , Character> map = new HashMap<>();
        map.put(']','[');
        map.put(')', '(');
        map.put('}', '{');

        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            //find pair
            if(map.containsKey(c)){
                if(!stk.isEmpty() && stk.peek() == map.get(c)){
                    stk.pop();
                }else{
                    //peek is not pair, not work 
                    return false;
                }
            }else{
                stk.push(c);
            }
        }
        // true/false
        return stk.isEmpty();

    }
}
