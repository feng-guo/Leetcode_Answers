class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        l = 0
        r = len(nums)-1
        
        while l < r:
            while nums[l]%2 == 0 and l < r:
                l += 1
            while nums[r] % 2 == 1 and l < r:
                r -= 1
            
            nums[l], nums[r] = nums[r], nums[l]
        
        return nums