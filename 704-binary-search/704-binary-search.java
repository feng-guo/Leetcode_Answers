class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right && nums[left] != target) {
            int mid = (left+right)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}