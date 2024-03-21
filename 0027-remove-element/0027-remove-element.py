class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        
        left = 0
        count = 0
        right = len(nums) - 1
        
        while left <= right:
            if nums[left] == val:
                count += 1
                while right > left and nums[right] == val:
                    right -= 1
                    count += 1
                nums[left], nums[right] = nums[right], nums[left]
                right -= 1
            left += 1
        
        return len(nums) - count