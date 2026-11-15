class Solution {
    public int numOfSubarrays(int[] arr) {
        Arrays.parallelPrefix(arr, Integer::sum);  // arr becomes its own prefix sums, in place
        long odd = Arrays.stream(arr).map(p -> p & 1).sum();  // odd prefix sums
        return (int) (odd * (arr.length + 1 - odd) % 1_000_000_007);  // the empty prefix is even
    }
}