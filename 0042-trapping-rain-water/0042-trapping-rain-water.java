class Solution {
    public int trap(int[] height) {
        int total=0;
        int n=height.length;
        int []sufixmax=new int [height.length];
         int []prefixmax=new int [height.length];
         prefixmax[0]=height[0];
         for(int i=1;i<n;i++){
                prefixmax[i]=Math.max(prefixmax[i-1],height[i]);
         }
         sufixmax[n-1]=height[n-1];
         for(int i=n-2;i>=0;i--){
            sufixmax[i]=Math.max(sufixmax[i+1],height[i]);
         }
         for(int i=0;i<n;i++){
            if(height[i]<prefixmax[i] && height[i]<sufixmax[i]){
                total+=Math.min(prefixmax[i],sufixmax[i])-height[i];
            }
         }
         return total;
    }
}