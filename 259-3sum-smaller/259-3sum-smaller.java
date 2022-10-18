class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return 0;
        }
        
        int count = 0;
        for (int i=0; i<nums.length-2; i++) {
            int l = i+1;
            int h = nums.length-1;
            int c = nums[i];
            
            while (l < h) {
                int f = nums[l];
                int b = nums[h];
                
                if (c+f+b<target) {
                    count+= h-l;
                    l++;
                } else {
                    h--;
                }
            }
        }
        return count;
    }
}