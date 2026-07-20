class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> ans;

        for (string& s : strs) {
            array<int, 26> count = {0};
            for (char c : s) {
                count[c - 'a']++;
            }

            string key;
            for (int num : count) {
                key += to_string(num) + "#";
            }
            ans[key].push_back(s);
        }
        vector<vector<string>> result;
        for (auto& entry : ans) {
            result.push_back(move(entry.second));
        }
        return result;        
    }
};