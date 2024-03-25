class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []
        
        for n in nums:
            #index to mark
            index = abs(n) - 1
            if nums[index] < 0:
                res.append(abs(n))
            else:
                nums[index] *= -1
        
        
        return res