class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        first_map = {}
        last_map = {}
        
        for i, c in enumerate(s):
            if c not in first_map:
                first_map[c] = i
            else:
                last_map[c] = i
        
        res = -1
        
        for c in first_map:
            if c in last_map:
                res = max(res, last_map[c] - first_map[c] - 1)
        
        return res
        