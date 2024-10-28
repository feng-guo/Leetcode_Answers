class Solution:
    def longestSquareStreak(self, nums: List[int]) -> int:
        used = set()
        nums_set = set(nums)
        nums.sort()
        res = 0
        
        for num in nums:
            current = num
            current_len = 1
            while num != -1:
                if num in used:
                    break
                used.add(num)
                next_num = int(num**2)
                if next_num in nums_set:
                    current = next_num
                    current_len += 1
                    num = next_num
                else:
                    num = -1
            
            res = max(res, current_len)
        
        
        return -1 if res == 1 else res