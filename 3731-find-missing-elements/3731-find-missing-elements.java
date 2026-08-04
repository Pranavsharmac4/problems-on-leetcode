class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> al = new ArrayList<>();
        if (nums == null || nums.length == 0) return al;
        
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            int expectedNext = nums[i - 1] + 1;
            while (expectedNext < nums[i]) {
                al.add(expectedNext);
                expectedNext++;
            }
        }
        
        return al;
    }
}