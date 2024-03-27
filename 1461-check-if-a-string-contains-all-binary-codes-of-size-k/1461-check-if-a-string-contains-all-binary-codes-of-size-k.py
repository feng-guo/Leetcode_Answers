class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        codes = set()
        
        substring = s[0:k]
        codes.add(substring)
        for i in range(k, len(s)):
            c = s[i]
            substring = substring[1:k] + c
            codes.add(substring)
        
        return len(codes) == 2**k
        