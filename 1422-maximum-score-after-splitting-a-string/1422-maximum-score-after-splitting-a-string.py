class Solution:
    def maxScore(self, s: str) -> int:
        count_zeroes = 0
        count_ones = 0
        
        for c in s:
            if c == "0":
                count_zeroes += 1
            else:
                count_ones += 1
                
        res = 0
        
        z1 = 0
        o1 = 0
        z2 = count_zeroes
        o2 = count_ones
        
        for i in range(0, len(s)-1):
            c = s[i]
            if c == "0":
                z1 += 1
                z2 -= 1
            else:
                o1 += 1
                o2 -= 1
            res = max(res, z1 + o2)
        
        return res