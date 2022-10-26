class Solution {
    public int missingNumber(int[] nums) {
        int test = 0;
        for (int i=0 ; i<nums.length+1; i++) {
            test ^= i;
        }
        for (int i=0 ; i<nums.length; i++) {
            test ^= nums[i];
        }
        return test;
    }
}