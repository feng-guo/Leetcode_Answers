class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s:
            return True
        if len(s) >= len(t) and s != t:
            return False
        s_index = 0
        for c in t:
            if s[s_index] == c:
                s_index += 1
            if s_index == len(s):
                return True
        return False