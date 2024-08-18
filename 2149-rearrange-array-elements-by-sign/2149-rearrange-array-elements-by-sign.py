class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)
        p_i = 0
        n_i = 1
        
        for num in nums:
            if num > 0:
                res[p_i] = num
                p_i += 2
            else:
                res[n_i] = num
                n_i += 2
        
        return res