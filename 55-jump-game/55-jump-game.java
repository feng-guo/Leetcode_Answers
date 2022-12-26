class Solution {
    Set<Integer> set;
    public boolean canJump(int[] nums) {
        set = new HashSet<>();
        set.add(0);
        return jump(nums, 0);
    }
    
    boolean jump(int[] nums, int index) {
        if (index == nums.length-1) {
            return true;
        }
        int max = nums[index];
        for (int i=1; i<= max; i++) {
            if (set.add(index+i)) {
                if (jump(nums, index+i)) {
                    return true;
                }
            } 
        }
        return false;
    }
}