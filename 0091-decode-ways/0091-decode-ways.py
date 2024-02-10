class Solution:
    def numDecodings(self, s: str) -> int:
        dp = {}
        def dfs(i):
            if i == len(s):
                return 1
            elif int(s[i]) == 0:
                 return 0
            elif i in dp:
                return dp[i]
            
            total = 0
            current = int(s[i])
            if i != len(s) -1 and ((current == 1) or (current == 2 and 0 <= int(s[i+1]) <= 6)):
                total += dfs(i + 2)
            total += dfs(i+1)
            dp[i] = total
            return total
        
        return dfs(0)
        