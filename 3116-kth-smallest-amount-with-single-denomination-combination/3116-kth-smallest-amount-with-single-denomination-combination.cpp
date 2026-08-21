class Solution {
public:
    using ll = long long;
    long long findKthSmallest(vector<int>& coins, int k) {
        ranges::sort(coins);
        vector<int> A;

        for (auto& c : coins)
            if (ranges::none_of(A, [&](int x) { return !(c % x); }))
                A.push_back(c);

        int n = A.size();

        auto check = [&](ll mid) {
            ll tot = 0;
            for (int i = 1; i <= n; i++) {
                int q = (1 << i) - 1;

                while (q < 1 << n) {
                    ll x = 1;
                    for (int j = 0; j < n; j++)
                        if ((q >> j) & 1)
                            x = lcm(x, A[j]);

                    tot += (mid / x) * (((i & 1) << 1) - 1);

                    int c = q & -q;
                    int r = q + c;
                    q = (((r ^ q) >> 2) / c) | r;
                }
            }
            return tot >= k;
        };

        ll low = k, high = 1ll * A[0] * k;
        return *ranges::lower_bound(views::iota(low, high + 1), true, {},
                                    [&](ll mid) { return check(mid); });
    }
};