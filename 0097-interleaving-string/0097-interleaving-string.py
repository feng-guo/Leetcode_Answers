from collections import defaultdict

class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        # if (len(s1) + len(s2)) != len(s3):
        #     return False
        
        dp = defaultdict(dict)
        
        def dfs(i, j, k):
            if i == len(s1) and j == len(s2) and k == len(s3):
                return True
            
            c1 = "0"
            c2 = "0"
            if (i < len(s1)):
                c1 = s1[i]
            if (j < len(s2)):
                c2 = s2[j]
            
            if k == len(s3):
                return False
            if c1 != s3[k] and c2 != s3[k]:
                dp[k][(i, j)] = False
                return False
            
            
            if (i, j) in dp[k]:
                return dp[k][(i, j)]
            
            res = False
            if (c1 == s3[k]):
                res = res or dfs(i+1, j, k+1)
            if (c2 == s3[k]):
                res = res or dfs(i, j+1, k+1)
            dp[k][(i, j)] = res
            return res
        
        return dfs(0, 0, 0)