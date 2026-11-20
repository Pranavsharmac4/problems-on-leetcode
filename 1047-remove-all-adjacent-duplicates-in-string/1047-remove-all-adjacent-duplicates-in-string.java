public class Solution {
    public String removeDuplicates(String S) {
        if (S == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(S.length());
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }}