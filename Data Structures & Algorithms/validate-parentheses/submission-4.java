class Solution {
    public boolean isValid(String s) {
        HashMap<Character , Character> map = new HashMap<>();
        map.put(']','[');
        map.put(')', '(');
        map.put('}', '{');

        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            //find pair
            if(map.containsKey(c) && !stk.isEmpty() && stk.peek() == map.get(c)){
                stk.pop();
            }else{
                stk.push(c);
            }
        }
        return stk.isEmpty() ? true : false;

    }
}
