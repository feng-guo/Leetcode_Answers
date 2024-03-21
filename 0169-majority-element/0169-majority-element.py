from collections import defaultdict

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        num_map = defaultdict(int)
        for num in nums:
            num_map[num] += 1
            if num_map[num] > len(nums) // 2:
                return num
        