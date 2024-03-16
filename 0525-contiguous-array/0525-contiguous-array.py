class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        zeros = 0
        ones = 0
        
        diff_map = {}
        res = 0
        for i, num in enumerate(nums):
            if num == 0:
                zeros += 1
            else:
                ones += 1
            if zeros == ones:
                res = i + 1
            elif zeros-ones not in diff_map:
                diff_map[zeros-ones] = i
            else:
                res = max(res, i - diff_map[zeros-ones])
        return res