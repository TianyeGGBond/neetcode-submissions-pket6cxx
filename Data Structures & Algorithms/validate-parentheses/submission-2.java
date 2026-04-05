class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()){
            if(!st.isEmpty()){
                    char p = st.peek();
                    if(
                         p == ')' ||
                         p == '}' ||
                         p == ']' 
                    ){
                        return false;
                    }
                    else if(
                        ( c == ')' && p == '(') ||
                        ( c == '}' && p == '{') ||
                        ( c == ']' && p == '[') 

                    ){
                        st.pop();
                        continue;
                    }
            }
            st.push(c);
        }
        return st.isEmpty();
    }
}
