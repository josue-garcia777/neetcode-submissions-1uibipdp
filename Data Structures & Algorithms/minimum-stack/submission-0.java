/*
two stacks one will have normal values
min values
stack [1, 2, 0]
min   [1, 1, 0]

*/

class MinStack {

    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minstack = new ArrayDeque<>();

    public MinStack() {

    }
    
    public void push(int val) {
   

        if(stack.isEmpty() && minstack.isEmpty()){
            minstack.push(val);
            stack.push(val);
            return;
        }

        if(val < minstack.peek()){
            stack.push(val);
            minstack.push(val);
            return;
        }

        minstack.push(minstack.peek());
        stack.push(val);

    }
    
    public void pop() {
        minstack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
