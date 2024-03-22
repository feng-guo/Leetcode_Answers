from collections import defaultdict

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix = defaultdict(int)
        prefix[0] = 1
        current_sum = 0
        res = 0
        for num in nums:
            current_sum += num
            res += prefix[current_sum-k]
            prefix[current_sum] += 1
        return res
        