class Solution {
    public int maxProduct(int[] nums) {
  int max1=1, max2=1;
  for(int ele:nums){
    if(max1<=ele){
        max2=max1;
        max1=ele;
    }
    else if(max2<=ele){
        max2=ele;
    }
  }
  return (max1-1)*(max2-1);
    }
}