import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> al = new ArrayList<>();
        backtrack(al, "", 0, 0, n);
        return al;
    }
    
    private void backtrack(List<String> list, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            list.add(current);
            return;
        }
        if (open < max) {
            backtrack(list, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, current + ")", open, close + 1, max);
        }
    }
}