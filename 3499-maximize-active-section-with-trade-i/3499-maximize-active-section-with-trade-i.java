class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray())
            if (c == '1')
                ones++;

        s = "1" + s + "1";

        int n = s.length();
        int i = 0;

        int ans = ones;
        while (i < n && s.charAt(i) == '1')
            i++;
        int c10 = 0;
        while (i < n && s.charAt(i) == '0') {
            c10++;
            i++;
        }

        while (i < n) {
            int c11 = 0;
            while (i < n && s.charAt(i) == '1') {
                c11++;
                i++;
            }

            if (c11 == 0)
                break;
            int c20 = 0;
            while (i < n && s.charAt(i) == '0') {
                c20++;
                i++;
            }

            if (c20 == 0)
                break;

            ans = Math.max(ans, ones + c10 + c20);
            c10 = c20;
        }

        return ans;
    }
}