class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        
        MOD = 1000000007
        res = 0
        right = len(nums) - 1
        for i in range(len(nums)):
            if nums[i]*2 > target:
                break
            
            while nums[right] + nums[i] > target:
                right -= 1
            
            res = (res + (2**(right-i))) % MOD
        
        return res