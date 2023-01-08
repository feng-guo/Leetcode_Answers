class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (nums[left]>nums[right]) {
            int mid = (left+right)/2;
            System.out.println("LEFT " + left + " MID " + mid + " RIGHT " + right);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}