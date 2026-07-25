class Solution {
    public int maxProduct(int n) {
        long m = 0;

        for (; n != 0; n /= 10)
            m += 1L << ((n % 10) << 2);

        int u = (64 - Long.numberOfLeadingZeros(m) - 1) >> 2;
        return u * ((64 - Long.numberOfLeadingZeros(m - (1L << (u << 2))) - 1) >> 2);
    }
}