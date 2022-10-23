class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] set = new int[nums.length];
        int[] arr = new int[2];
        
        for (int i=0; i<nums.length; i++) {
            set[nums[i]-1]++;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (set[i] == 0) {
                arr[1] = i+1;
            }
            if (set[i] == 2) {
                arr[0] = i+1;
            }
        }
        
        return arr;
    }
}