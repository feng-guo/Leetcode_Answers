import math

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        dp = [0 for n in nums]
        
        first_negative = -1
        current = 0
        max_product = -math.inf
        
        for i in range(len(nums)):
            num = nums[i]
            current *= num
            if (current == 0):
                current = num
            dp[i] = current
            max_product = max(max_product, current)
            if (num == 0):
                first_negative = -1
            if (current < 0):
                if (first_negative != -1):
                    max_product = max(max_product, int(dp[i]/dp[first_negative]))
                else:
                    first_negative = i
                
                
            
                                                                                                                                  
            
        
        return max_product
        