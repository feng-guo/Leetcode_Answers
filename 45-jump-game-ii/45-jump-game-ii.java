class Solution {
    public int jump(int[] nums) {
        int[] min = new int[nums.length];
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] + i > max) {
                
                for (int j=max+1; j<=Math.min(nums[i]+i, nums.length-1); j++) {
                    min[j] = min[i]+1;
                }
                
                
                max = nums[i] + i;
            }
        }
        
        return min[nums.length-1];
    }
}