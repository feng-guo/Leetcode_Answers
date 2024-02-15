class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        
        sums = 0
        res = -1
        
        for num in nums:
            if sums > num:
                res = max(res, sums+num)
            sums += num
        
        return res
        