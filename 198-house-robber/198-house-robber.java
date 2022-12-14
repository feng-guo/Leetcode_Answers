class Solution {
    public int rob(int[] nums) {
        int max = 0;
        int[] max_house = new int[nums.length];
        max_house[0] = nums[0];
        if (nums.length > 1) {
            max_house[1] = nums[1];
        } else {
            return nums[0];
        }
        if (nums.length > 2) {
            max_house[2] = max_house[0] + nums[2];
        } else {
            return Math.max(nums[0], nums[1]);
        }
        max = Math.max(max_house[0], Math.max(max_house[1], max_house[2]));
        for (int i=3; i<nums.length; i++) {
            max_house[i] = nums[i] + Math.max(max_house[i-2], max_house[i-3]);
            max = Math.max(max, max_house[i]);
        }
        return max;
    }
}