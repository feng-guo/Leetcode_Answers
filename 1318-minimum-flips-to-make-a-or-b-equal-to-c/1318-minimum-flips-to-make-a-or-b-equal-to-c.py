class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        flips = 0
        while a > 0 or b > 0 or c > 0:
            a1 = a%2
            b1 = b%2
            c1 = c%2
            
            if c1 == 0:
                if a1 == 1:
                    flips += 1
                if b1 == 1:
                    flips += 1
            else:
                if a1 == b1 == 0:
                    flips += 1
            
            a //= 2
            b //= 2
            c //= 2
        
        return flips