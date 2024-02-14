class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        dp = [[-1 for y in t] for x in s]
        
        def dfs(x, y):
            if y == len(t):
                return 1
            if x == len(s):
                return 0
            if dp[x][y] != -1:
                return dp[x][y]
            if (s[x] == t[y]):
                dp[x][y] = dfs(x+1, y+1) + dfs(x+1, y)
            else:
                dp[x][y] = dfs(x+1, y)
            return dp[x][y]
        
        dfs(0,0)
        return dp[0][0]
        
        
        