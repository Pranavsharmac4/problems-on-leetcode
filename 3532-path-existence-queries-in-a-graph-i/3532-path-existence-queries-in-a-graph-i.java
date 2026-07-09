class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] queryResult = new boolean[queries.length];

        int prevNum = nums[0];
        nums[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prevNum <= maxDiff) {
                prevNum = nums[i];
                nums[i] = nums[i - 1] + 1;
            } else {
                prevNum = nums[i];
                nums[i] = 0;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            if (Math.abs(queries[i][0] - queries[i][1]) <=
                nums[Math.max(queries[i][0], queries[i][1])]) {
                queryResult[i] = true;
            }
        }

        return queryResult;
    }
}