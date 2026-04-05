class MinStack {
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            int p = stack.pop();
            temp.push(p);
            min = Math.min(min, p);
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return min;
    }
}
