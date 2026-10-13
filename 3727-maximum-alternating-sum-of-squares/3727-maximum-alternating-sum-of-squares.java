class Solution {
    private final Random random = new Random();

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length, h = n / 2;
        long[] sq = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
            total += sq[i];
        }
        select(sq, h);  // quickselect: the smallest half in front, any order
        long small = 0;
        for (int i = 0; i < h; i++) small += sq[i];
        return total - 2 * small;  // add everything, then flip the smallest half to minus
    }

    private void select(long[] a, int k) {  // put the k smallest values in a[0..k), like C++ nth_element
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            long pivot = a[lo + random.nextInt(hi - lo + 1)];
            int lt = lo, i = lo, gt = hi;  // a[lo..lt) < pivot, a[lt..i) == pivot, a(gt..hi] > pivot
            while (i <= gt) {
                if (a[i] < pivot) swap(a, lt++, i++);
                else if (a[i] > pivot) swap(a, i, gt--);
                else i++;
            }
            if (k < lt) hi = lt - 1;  // the boundary is among the smaller values
            else if (k > gt + 1) lo = gt + 1;  // the boundary is among the bigger values
            else return;  // the boundary falls on the pivot copies: done
        }
    }

    private void swap(long[] a, int i, int j) {
        long t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}