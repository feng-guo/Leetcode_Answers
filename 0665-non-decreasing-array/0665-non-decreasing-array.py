class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        checkIndex = -1
        
        for i in range(len(nums)-1):
            if nums[i] > nums[i+1]:
                if checkIndex != -1:
                    return False
                else:
                    checkIndex = i
        
        if checkIndex != -1:
            ## I either need to remove the number at check index or the next number
            
            
            left = float("-inf")
            if checkIndex > 0:
                left = nums[checkIndex-1]
            right = nums[checkIndex+1]
            if left <= right:
                ## Can just remove the middle index
                return True
            left = nums[checkIndex]
            right = float("inf")
            if checkIndex < len(nums) - 2:
                right = nums[checkIndex+2]
            if left <= right:
                return True
            return False
        else:
            return True