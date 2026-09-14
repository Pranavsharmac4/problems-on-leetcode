class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> ump;
        int l = 0, ans = 0;

        for (int i = 0; i < s.size(); i++) {
            ump[s[i]]++;

            while (ump[s[i]] > 1) {
                ump[s[l]]--;
                l++;
            }

            ans = max(ans, i - l + 1);
        }

        return ans;
    }
};