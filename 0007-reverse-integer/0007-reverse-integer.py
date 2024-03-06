class Solution:
    def reverse(self, x: int) -> int:
        is_neg = x < 0
        if x < 0:
            x *= -1
        res = 0
        while x:
            res *= 10
            res += x % 10
            x = x//10
            if 0 < x < 10 and res > 2**31//10:
                return 0
        res = res*-1 if is_neg else res 
        return res