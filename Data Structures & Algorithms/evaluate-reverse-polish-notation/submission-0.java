class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            int num = 0;
            if (s.equals("+")) num = stack.pop() +stack.pop();
            else if (s.equals("*")) num = stack.pop() *stack.pop();
            else if (s.equals("-")) {
                int next = stack.pop();
                int pre = stack.pop();
                num = pre - next;
            }
            else if (s.equals("/")) {
                int next = stack.pop();
                int pre = stack.pop();
                num = pre / next;
            }
            else num = Integer.parseInt(s);
            stack.push(num);
        }
        return stack.pop();
    }
}
