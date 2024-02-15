class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        dp = {}
        
        
        def dfs(x, y):
            if (x, y) in dp:
                return dp[(x, y)]
            
            if x >= len(s) and y >= len(p):
                return True
            if y >= len(p):
                return False
            
            if x < len(s) and (s[x] == p[y] or p[y] == "."):
                if y + 1 != len(p) and p[y+1] == "*":
                    dp[(x, y)] = dfs(x+1, y) or dfs(x, y+2)
                    return dp[(x, y)]
                else:
                    dp[(x, y)] = dfs(x+1, y+1)
                    return dp[(x, y)]
            
            if y + 1 < len(p) and p[y+1] == "*":
                #Match none
                dp[(x, y)] = dfs(x, y+2)
                return dp[(x, y)]
            
            return False
            
        return dfs(0, 0)
    

# "aa"
# "a"
# "aa"
# "a*"
# "ab"
# ".*"
# "test"
# "**"
# "aab"
# "c*a*b"
# "a"
# "ab*"
# "ab"
# ".*c"
        