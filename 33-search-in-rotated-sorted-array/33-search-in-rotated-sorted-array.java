class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[left] == target) {
                return left;
            } else if (nums[mid] == target) {
                return mid;
            } else if (nums[right] == target) {
                return right;
            }
            if ( (target > nums[mid] && target < nums[right] && nums[mid] <= nums[right]) || (target > nums[mid] && target > nums[right] && nums[mid] >= nums[right]) || (target < nums[mid] && target < nums[right] && nums[mid] >= nums[right]) ) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}