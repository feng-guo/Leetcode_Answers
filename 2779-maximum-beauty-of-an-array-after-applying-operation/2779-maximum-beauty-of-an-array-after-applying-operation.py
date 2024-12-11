class Solution:
    def maximumBeauty(self, nums: list[int], k: int) -> int:
        nums.sort()
        left = 0
        max_beauty = 0

        # Iterate through the array with the right pointer
        for right in range(len(nums)):
            # Move the left pointer to maintain the valid range
            while nums[right] - nums[left] > 2 * k:
                left += 1
            # Update the maximum beauty based on the current range
            # We do not add 1 here as right is already pointing to one position beyond the valid range.
            max_beauty = max(max_beauty, right - left + 1)

        return max_beauty