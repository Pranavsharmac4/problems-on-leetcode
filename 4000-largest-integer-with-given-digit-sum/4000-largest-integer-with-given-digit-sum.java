class Solution {
    public int largestInteger(int n, int s) {
       if(s>9*n)return -1;
        int rs=0;
        for(int i=0;i<n;i++){
            int curr=Math.min(9,s);
            rs=rs*10+curr;
            s-=curr;     
        }
        return rs;
    }
}