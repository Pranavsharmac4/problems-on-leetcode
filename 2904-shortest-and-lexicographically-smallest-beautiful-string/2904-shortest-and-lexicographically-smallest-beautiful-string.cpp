int bit_width(__uint128_t x) {
    uint64_t hi = x >> 64;
    return hi ? 128 - countl_zero(hi) : 64 - countl_zero((uint64_t)x);
}

class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n = s.size(), start = n;
        __uint128_t curr = 0, best = -1;

        for (int i = 0; i < n; i++) {
            // append bit to curr
            curr = (curr << 1) | (s[i] & 1);
            k -= s[i] & 1;
            // too many ones, pop the most significant bit
            if (k < 0)
                k = 0, curr &= ((__uint128_t)1 << (bit_width(curr) - 1)) - 1;
            // exactly k ones, compare masks
            if (k == 0 && curr < best)
                start = i - bit_width(curr) + 1, best = curr;
        }

        return move(s).substr(start, bit_width(best));
    }
};