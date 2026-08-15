class Solution {
    public int longestSubsequence(int[] nums) {
         int n = nums.length;
        int totalXOR = 0;
        boolean allZero = true;
        for(int c : nums) {
            totalXOR ^= c;
            if(c != 0) allZero = false;
        }
        if(allZero) return 0;
        if(totalXOR != 0) return n;
        return n-1;
    }
}