class Solution {
public:
    int maxDepth(std::string s) {
        int depth = 0;
        int r = 0;
        for (char c : s) {
            if (c == ')') {
                depth--;
                continue;
            }
            // Digits and operators
            if (c != '(') continue;
            depth++;
            // New max only possible after '('
            if (depth > r) r = depth;
        }
        return r;
    }
};