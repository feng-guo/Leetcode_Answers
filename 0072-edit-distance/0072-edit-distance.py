import math

class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        dp = [[-1 for y in word2] for x in word1]
        
        def dfs(x, y):
            if x == len(word1) and y == len(word2):
                return 0
            if x == len(word1):
                return len(word2) - y
            if y == len(word2):
                return len(word1) - x
            if dp[x][y] != -1:
                return dp[x][y]
            res = math.inf
            c1 = word1[x]
            c2 = word2[y]
            if (c1 == c2):
                res = min(res, dfs(x+1, y+1))
            res = min(res, 1 + min(dfs(x, y+1), dfs(x+1, y), dfs(x+1, y+1)))
            dp[x][y] = res
            return res
        
        return dfs(0, 0)