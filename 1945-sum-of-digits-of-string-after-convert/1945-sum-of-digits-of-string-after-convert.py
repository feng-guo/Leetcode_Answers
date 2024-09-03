class Solution:
    def getLucky(self, s: str, k: int) -> int:
        num = 0
        k -= 1
        
        print(ord('a'))
        
        for c in s:
            n = ord(c) - 96
            num += n//10 + n%10
        
        while k > 0:
            n = num
            num = 0
            
            while n > 0:
                num += n%10
                n //= 10
            
            
            k -= 1
        
        
        return num
        