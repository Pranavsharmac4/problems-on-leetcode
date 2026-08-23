class Solution {
public:
    bool sumGame(string A) {
        int sum[2] = {0, 0}, q[2] = {0, 0};
        int n = A.length();

        for (int i = 0; i < n; i++) {
            int j = i / (n >> 1);
            if (A[i] == '?')
                q[j]++;
            else
                sum[j] += A[i] - '0';
        }

        return ((q[0] + q[1]) & 1) ||
               ((sum[0] - sum[1]) << 1) != (q[1] - q[0]) * 9;
    }
};