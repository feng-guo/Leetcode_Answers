from collections import defaultdict

class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        free = defaultdict(int)
        res = 0
        for num in nums:
            if free[k-num] > 0:
                free[k-num] -= 1
                res += 1
            else:
                free[num] += 1
        return res