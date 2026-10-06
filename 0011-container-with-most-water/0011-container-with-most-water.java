class Solution {
    public int maxArea(int[] height) {
     int maxArea=0;
     int left=0;
     int right=height.length-1;
     while(left<right){
        int h=right-left;
        maxArea=Math.max(maxArea,Math.min(height[left],height[right])*h);
        if(height[left]<height[right]){
            left++;
        }
        else{
            right--;
        }
     }  
     return maxArea;   
    }
}