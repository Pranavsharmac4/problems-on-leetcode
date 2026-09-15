class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2]; // Initial best guess

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum == target) return target;
                else if (sum < target) left++;
                else right--;
            }
        }

        return result;
    }
}