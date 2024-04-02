class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        nums.sort()
        
        use_left = True
        r = len(nums) - 1
        l = 0
        res = []
        while l <= r:
            if use_left:
                res.append(nums[l])
                l += 1
                use_left = False
            else:
                res.append(nums[r])
                r -= 1
                use_left = True
        
        
        return res