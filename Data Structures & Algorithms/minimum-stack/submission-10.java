class MinStack {
    Stack<Integer> main_stk;
    Stack<Integer> min_stk;

    public MinStack() {
        main_stk = new Stack<>();
        min_stk = new Stack<>();
    }
    
    public void push(int val) {
        
        if(min_stk.isEmpty() || val <= min_stk.peek()){
            min_stk.push(val);
        }
        System.out.println("after push" + min_stk.peek());
        
        main_stk.push(val);

        System.out.println("after push main" + main_stk.peek());
    }
    
    public void pop() {
        System.out.println("before pop" + min_stk.peek() );
        System.out.println("before pop main" + main_stk.peek());
        if(main_stk.peek() <= min_stk.peek()){
            min_stk.pop();
        }
        main_stk.pop();
        if(!main_stk.isEmpty()) System.out.println("after pop main" + main_stk.peek());
    }
    
    public int top() {
        return main_stk.peek();
    }
    
    public int getMin() {
        return min_stk.peek();
    }
}
