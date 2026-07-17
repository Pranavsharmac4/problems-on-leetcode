class Solution {
    using ll = long long;
    static const int N = 50001;
public:
    vector<int> gcdValues(vector<int>& A, vector<long long>& queries) {
        int max = 0;
        int freq[N] = {0};

        for (auto& n : A) {
            freq[n]++;
            max = ::max(max, n);
        }

        ll mFreq[N] = {0};
        ll pairs[N] = {0};
        ll overlaps[N] = {0};
        ll GCD[N] = {0};

        for (int i = max; i > 0; i--) {
            ll sum = 0, extra = 0;

            for (int j = i; j <= max; j += i) {
                sum += freq[j];
                extra += GCD[j];
            }

            mFreq[i] = sum;
            pairs[i] = sum * (sum - 1) / 2;
            overlaps[i] = extra;
            GCD[i] = pairs[i] - overlaps[i];
        }

        for (int i = 1; i <= max; i++)
            GCD[i] += GCD[i - 1];

        vector<int> res(queries.size());
        for (int i = 0; i < queries.size(); i++)
            res[i] = upper_bound(GCD, GCD + max + 1, queries[i]) - GCD;

        return res;
    }
};