class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        isOnePresent = False
        
        for num in nums:
            if num == 1:
                isOnePresent = True
        
        for i, num in enumerate(nums):
            if num < 0:
                nums[i] = 0
        
        for i, num in enumerate(nums):
            actualNumber = abs(num)
            if actualNumber > len(nums):
                # Don't need to mark anything outside of this range as there has to be a number missing inside the range of nums
                continue
            index = actualNumber - 1
            if index > 0:
                if nums[index] == 0:
                    nums[index] = -1
                elif nums[index] > 0:
                    nums[index] *= -1
            
        if not isOnePresent:
            return 1
        
        for i in range(1, len(nums)):
            if nums[i] >= 0:
                return i + 1
       
        return len(nums) + 1
            