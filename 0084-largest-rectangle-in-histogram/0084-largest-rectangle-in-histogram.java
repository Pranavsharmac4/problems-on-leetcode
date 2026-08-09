class Solution {
    public int largestRectangleArea(int[] arr  ) {
        Stack<Integer>st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<arr.length;i++){
            while(!st.empty()&& arr[st.peek()]>arr[i]){
                int element=st.peek();
                st.pop();
                int nse=i;
                int pse=st.empty()?-1:st.peek();
                maxArea=Math.max(maxArea,(nse-pse-1)*arr[element]);
            }
              st.push(i);
            
        }
        int n=arr.length;
        while(!st.empty()){
            int nse=n;
              int element=st.peek();
            st.pop();
            int pse=st.empty()?-1:st.peek();
            maxArea=Math.max(maxArea,(nse-pse-1)*arr[element]);
        }
        return maxArea;
    }
}