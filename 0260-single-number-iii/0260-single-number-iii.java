class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        int bitmask = diff & -diff;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & bitmask) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}