class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        res = float("inf")
        total = sum(nums)
        target = total-x
        current = 0
        l = 0
        for i, num in enumerate(nums):
            current += num
            if current == target:
                res = min(res, len(nums) - (i - l + 1))
            while current > target and l <= i:
                current -= nums[l]
                l += 1
            if current == target:
                res = min(res, len(nums) - (i - l + 1))
        
        
        if res == float("inf"):
            return -1
        else:
            return res