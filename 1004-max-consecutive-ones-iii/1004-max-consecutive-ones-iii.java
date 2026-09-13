class Solution {
    public int longestOnes(int[] nums, int k) {
        return fun(nums,0,0,0,k);
    }
    int fun(int arr[], int count, int x, int ans, int k){
        if(x >= arr.length){
            return ans;
        }
        int r_k = k;
        for(int i=x; i<arr.length; i++){
            if(arr[i] == 1){
                count++;
            }else if(r_k != 0){
                count++;r_k--;
            }
            else break;
        }
        ans = Math.max(ans, count);
        return fun(arr,0,x+1,ans,k);
    }
}