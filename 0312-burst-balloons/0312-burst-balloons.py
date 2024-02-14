class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        dp = [[-1 for n in nums] for t in nums]
        
        def dfs(l, r):
            if l > r:
                return 0
            if dp[l][r] != -1:
                return dp[l][r]
            for i in range(l, r+1):
                left_value = 1
                right_value = 1
                if l != 0:
                    left_value = nums[l-1]
                if r != len(nums) - 1:
                    right_value = nums[r+1]
                count = left_value*nums[i]*right_value
                
                count += dfs(l, i-1) + dfs(i+1, r)
                dp[l][r] = max(dp[l][r], count)
            return dp[l][r]
            
        
        return dfs(0, len(nums)-1)