class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        res = 0 
        total = 0
        l = 0
        for i, num in enumerate(nums):
            total += num
            while total + k < (i - l + 1)*num and l < i:
                total -= nums[l]
                l += 1
            res = max(res, (i - l + 1))
        
        
        return res