class Solution {
    private final long MOD = 1000000007;
    public int countValidSequences(int n, int k) {
        if (k >n) {
            return 0;
        }
        long total = nCr(n - 1, k - 1);
        long oddOnly = 0;
        if ((n + k) % 2 == 0) {
            int m = (n + k) / 2;
            oddOnly = nCr(m - 1, k - 1);
        }
        long ans = (total - oddOnly + MOD) % MOD;
        return (int) ans;
    }
    private long nCr(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        if (r == 0 || r == n) {
            return 1;
        }
        if (r > n / 2) {
            r = n - r;
        }
        long num = 1;
        long den = 1;
        for (int i = 0; i < r; i++) {
            num = (num * (n - i)) % MOD;
            den = (den * (i + 1)) % MOD;
        }
        return (num * power(den, MOD - 2)) % MOD;
    }
    private long power(long x, long y) {
        long res = 1;
        x = x % MOD;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % MOD;
            }
            y = y >> 1;
            x = (x * x) % MOD;
        }
        return res;
    }
}