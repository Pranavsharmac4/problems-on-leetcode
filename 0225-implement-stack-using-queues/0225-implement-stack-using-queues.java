class MyStack {
    Queue<Integer> primary = new LinkedList<>();
    Queue<Integer> secondary = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        primary.add(x);
    }
    
    public int pop() {
        if(!empty()){
            while(primary.size() != 1){
                secondary.add(primary.remove());
            }
            int removed = primary.remove();
            while(secondary.size() != 0){
                primary.add(secondary.remove());
            }
            return removed;
        }
        return 0;
    }
    
    public int top() {
        if(!empty()){
            while(primary.size() != 1){
                secondary.add(primary.remove());
            }
            int peek = primary.peek();
            secondary.add(primary.remove());
            while(secondary.size() != 0){
                primary.add(secondary.remove());
            }
            return peek;
        }
        return 0;
    }
    
    public boolean empty() {
        return primary.isEmpty();
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