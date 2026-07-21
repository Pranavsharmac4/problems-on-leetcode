class Solution {
public:
    int minAddToMakeValid(string s) {
        stack<char> S;
        int c = 0;
        for (char i : s) {
            if (i == '(')
                S.push(i);
            else {
                if (S.empty())
                    c++;
                else
                    S.pop();
            }
        }
        return c + S.size();
    }
};