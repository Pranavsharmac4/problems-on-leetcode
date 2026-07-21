import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i); 
            } else if (arr[i] == ')') {
                if (stack.isEmpty()) {
                    arr[i] = '*';
                } else {
                    stack.pop();
                }
            }
        }
        
        while (!stack.isEmpty()) {
            arr[stack.pop()] = '*';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}