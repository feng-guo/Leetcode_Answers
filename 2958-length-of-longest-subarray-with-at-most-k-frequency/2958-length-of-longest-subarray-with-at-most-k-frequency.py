from collections import defaultdict

class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        freq_map = defaultdict(int)
        current_length = 0
        end_index = 0
        res = 0
        for num in nums:
            while freq_map[num] == k:
                freq_map[nums[end_index]] -= 1
                current_length -= 1
                end_index += 1
            freq_map[num] += 1
            current_length += 1
            res = max(res, current_length)
        
        return res
        