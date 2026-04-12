class MinStack {
    //Integer是对象而不是基本类型int
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
        main_stk.push(val);

    }
    
    public void pop() {
        //main_stk.peek() 和 min_stk.peek() 返回的是 Integer 对象。
        //在 Java 里，== 比较对象时，比较的是“是不是同一个对象”，不是值是否相等。
        if(main_stk.peek().equals(min_stk.peek())){  //或者<=会自动比较值
            min_stk.pop();
        }
        main_stk.pop();
    }
    
    public int top() {
        return main_stk.peek();
    }
    
    public int getMin() {
        return min_stk.peek();
    }
}
