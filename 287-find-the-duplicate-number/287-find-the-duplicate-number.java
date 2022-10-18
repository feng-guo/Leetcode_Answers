class Solution {
    public int findDuplicate(int[] nums) {
        int intersect = findIntersect(nums);
        return findDuplicate(nums, intersect);
    }
    
    public int findIntersect(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                return slow;
            }
        }
    }
    
    public int findDuplicate(int[] nums, int intersect) {
        int start = 0;
        while (true) {
            start = nums[start];
            intersect = nums[intersect];
            if (start == intersect) {
                return start;
            }
        }
    }
}