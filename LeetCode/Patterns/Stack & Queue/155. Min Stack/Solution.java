class MinStack {

    Stack<Long> stack = new Stack<>();
    long mini;

    public MinStack() {
        mini = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v = val;

        if (stack.isEmpty()) {
            mini = v;
            stack.push(v);
        } else if (v >= mini) {
            stack.push(v);
        } else {
            stack.push(2 * v - mini);
            mini = v;
        }
    }
    
    public void pop() {
        if (stack.isEmpty())
            return;

        long x = stack.pop();
        if (x < mini)
            mini = 2 * mini - x;
    }
    
    public int top() {
        if (stack.isEmpty())
            return -1;

        long x = stack.peek();
        return (x >= mini) ? (int)x : (int)mini;
    }
    
    public int getMin() {
        return (int)mini;
    }
}
