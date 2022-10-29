class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        int last = -1;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else if (nums[i] == 0 && last == -1) {
                last = i;
                count++;
            } else {
                count = i - last;
                last = i;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}