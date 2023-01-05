class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        stack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        if (minStack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = minStack.peek();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */