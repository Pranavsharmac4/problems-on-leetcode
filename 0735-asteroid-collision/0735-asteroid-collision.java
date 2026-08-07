class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0)st.push(arr[i]);
            else{
                while(!st.empty()&&st.peek()>0&&st.peek()<Math.abs(arr[i]))st.pop();
            
            if(!st.empty()&&st.peek()==Math.abs(arr[i]))st.pop();
            else if(st.empty()|| st.peek()<0)st.push(arr[i]);
            }
        }
    
    int res[]=new int[st.size()];
    for(int i=res.length-1; i>=0;i--){
        res[i]=st.pop();
    }
      return res;
        }
}