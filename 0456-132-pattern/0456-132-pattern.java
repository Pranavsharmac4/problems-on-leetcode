class Solution {
    public boolean find132pattern(int[] nums) {
        int thirdElement = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < thirdElement) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                thirdElement = stack.pop();
            }
            stack.push(nums[i]);
        }
        
        return false;
    }
}