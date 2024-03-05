class Solution:
    def minimumLength(self, s: str) -> int:
        l = 0
        r = len(s) - 1
        
        while s[l] == s[r] and l != r:
            c = s[l]
            left = l
            while l != r and s[l] == c:
                l += 1
            if l == r:
                return 0
            while s[r] == c:
                r -= 1
        
        return len(s[l:r+1])
        