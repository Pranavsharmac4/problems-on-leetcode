class Solution {
    static final int[] q = new int[45];
    static {
        int n = 0;
        for (int i = 1; i < 10; i++)
            q[n++] = i;
        for (int i = 0; i < n; i++) {
            int d = q[i] % 10;
            if (d < 9) 
                q[n++] = q[i] * 10 + d + 1;
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        for (int x : q)
            if (x >= low && x <= high)
                res.add(x);
        return res;
    }
}