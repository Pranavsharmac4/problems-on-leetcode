class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>(); 
        
        int j = 0;
        
        for(int val : pushed){
            st.push(val); 
            while(!st.isEmpty() && st.peek() == popped[j]){ 
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}