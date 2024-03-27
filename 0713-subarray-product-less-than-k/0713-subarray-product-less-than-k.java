class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int low = 0;
        int current = nums[0];
        int count = 0;
        
        if (nums[0] < k) {
            count++;
        }
        
        for (int i=1; i<nums.length; i++) {
            current *= nums[i];
            while (current >= k && low < i) {
                current /= nums[low];
                low++;
            }
            if (current < k) {
                count += (i - low) + 1;
            }
        }
        return count;
    }
}