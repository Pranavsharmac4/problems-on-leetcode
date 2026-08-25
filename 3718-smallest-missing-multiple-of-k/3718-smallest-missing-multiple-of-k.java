class Solution {
    public int missingMultiple(int[] nums, int k) {
        long[] x = {0L, 0L};
        for (int n : nums)
            if (n % k == 0) {
                int i = n / k - 1;
                x[i >> 6] |= 1L << (i & 63);
            }
            
        int z = x[0] == -1L ? 1 : 0;
        return (z * 64 + Long.numberOfTrailingZeros(++x[z] & -x[z]) + 1) * k;
    }
}