class Solution {
    public int  maxrectangle(int []arr){
        Stack<Integer>st=new Stack<>();
        int maxArea=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(!st.empty()&&arr[st.peek()]>arr[i]){
                int element=st.peek();
                st.pop();
                int nse=i;
                int pse=st.empty()?-1:st.peek();
                maxArea=Math.max(maxArea,(nse-pse-1)*arr[element]);
                }
                st.push(i);
        }
        while(!st.empty()){
           int nse=n;
           int element=st.peek();
           st.pop();
        int pse = st.empty()?-1:st.peek();
        maxArea=Math.max(maxArea,(nse-pse-1)*arr[element]);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] arr) {
        int max=0;
       //prefix sum;
       int n=arr.length;
       int m=arr[0].length; 
       int psum[][]=new int[n][m];
       for(int j=0;j<m;j++){
        int sum=0;
        for(int i=0;i<n;i++){
        if(arr[i][j]=='1'){
            psum[i][j] = (i == 0) ? 1 : psum[i - 1][j] + 1;
        }
        else{
            psum[i][j]=0;
        }
        }
       }
       for(int i=0;i<n;i++){
        max=Math.max(max,maxrectangle(psum[i]));
       }
       return max;
    }
}