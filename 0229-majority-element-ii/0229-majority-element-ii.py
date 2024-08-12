from collections import defaultdict
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        freq_map = defaultdict(int)
        for num in nums:
            freq_map[num] += 1
        
        res = []
        for key in freq_map:
            if freq_map[key] > len(nums)//3:
                res.append(key)
        
        return res