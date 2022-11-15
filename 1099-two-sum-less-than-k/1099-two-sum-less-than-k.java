class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int best = -1;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i != j && nums[i] + nums[j] < k) {
                    best = Math.max(nums[i] + nums[j], best);
                }
            }
        }
        return best;
    }
}