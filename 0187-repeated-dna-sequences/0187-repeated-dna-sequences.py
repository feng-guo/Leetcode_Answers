from collections import defaultdict

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        subsequences = defaultdict(int)
        
        sequence = s[0:10]
        subsequences[sequence] += 1
        for i in range(10, len(s)):
            c = s[i]
            
            sequence = sequence[1:10] + c
            subsequences[sequence] += 1
            
        res = []
        for sub in subsequences:
            if subsequences[sub] > 1:
                res.append(sub)
        return res
        