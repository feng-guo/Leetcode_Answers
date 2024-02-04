class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = {}
        
        def dfs(i, buying):
            if i >= len(prices):
                return 0
            elif (i, buying) in dp:
                return dp[(i, buying)]
            elif buying:
                buy = dfs(i+1, not buying) - prices[i]
                cd = dfs(i+1, buying)
                dp[(i, buying)] = max(buy, cd)
            else:
                sell = dfs(i+2, not buying) + prices[i]
                cd = dfs(i+1, buying)
                dp[(i, buying)] = max(sell, cd)
            return dp[(i, buying)]
        
        return dfs(0, True)
                