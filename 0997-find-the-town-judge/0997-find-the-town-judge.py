from collections import defaultdict

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1 and not trust:
            return 1
            
        trusts = defaultdict(int)
        trusted = defaultdict(int)
        
        for edge in trust:
            a, b = edge
            trusts[a] += 1
            trusted[b] += 1
        
        for t in trusted:
            if trusted[t] == n-1 and trusts[t] == 0:
                return t
        
        return -1