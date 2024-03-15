class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:    
        answer = [1 for _ in nums]
        for i in range(1, len(nums)):
            answer[i] = nums[i-1] * answer[i-1]
        right = 1
        for i in range(len(nums)):
            answer[-(i+1)] *= right
            right *= nums[-(i+1)]
            
        return answer
        