class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        b = 0
        a = 0
        l = 0
        o = 0
        n = 0
        for c in text:
            if c == "b":
                b += 1
            if c == "a":
                a += 1
            if c == "l":
                l += 1
            if c == "o":
                o += 1
            if c == "n":
                n += 1
        return min(b, a, l//2, o//2, n)    
        
        