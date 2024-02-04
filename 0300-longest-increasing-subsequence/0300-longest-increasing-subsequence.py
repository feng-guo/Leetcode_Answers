class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        dp = [0 for x in nums]
        
        def dfs(index):
            if dp[index] != 0:
                return dp[index]
            res = 0
            for i in range(index+1, len(nums)):
                if nums[index] < nums[i]:
                    res = max(dfs(i), res)
            dp[index] = res + 1
            return dp[index]
        
        res = 0
        for i in range(len(nums)):
            res = max(dfs(i), res)
        
        return res
                    
                    
            
        