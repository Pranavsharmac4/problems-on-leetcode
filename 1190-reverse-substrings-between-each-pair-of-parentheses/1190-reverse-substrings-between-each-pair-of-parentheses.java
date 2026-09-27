class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] link = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                stk.push(i);
            else if (s.charAt(i) == ')') {
                link[i] = stk.pop();
                link[link[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, dir = 1; i < n; i += dir) {
            if (s.charAt(i) >= 'a')
                sb.append(s.charAt(i));
            else {
                i = link[i];
                dir = -dir;
            }
        }
        
        return sb.toString();
    }
}