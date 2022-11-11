class Solution {
    public int removeDuplicates(int[] nums) {
        int lag = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[lag]) {
                //need to move
            } else {
                lag++;
                nums[lag] = nums[i];
            }
        }
        return lag+1;
    }
}