class MyStack {
    private final Queue<Integer> q = new LinkedList<>();
    //2,1
    public MyStack() {
        
    }
    
    public void push(int x) {
         q.offer(x);
    }
    
    public int pop() {
         if (q.isEmpty()) {
            return -1;
        }

        for(int i=0; i<q.size()-1; i++){
            q.offer(q.poll());
        }

        return q.poll();
    }
    
    public int top() {        
        Iterator<Integer> iterator = q.iterator();
        int top = 0;

        while (iterator.hasNext()) {
            top = iterator.next();
        }
        return top;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */