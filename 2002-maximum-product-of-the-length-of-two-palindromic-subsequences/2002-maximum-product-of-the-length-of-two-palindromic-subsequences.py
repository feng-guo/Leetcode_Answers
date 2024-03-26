class Solution:
    def maxProduct(self, s: str) -> int:
        
        def isPalindrome(s):
            return s == s[::-1]
        
        def createString(i, s):
            index = 0
            res = ""
            while i:
                if i & 1:
                    res += s[index]
                i >>= 1
                index += 1
            return res
            
        palindromes = {}
        
        for i in range(1, 2**len(s)):
            subsequence = createString(i, s)
            if isPalindrome(subsequence):
                palindromes[i] = subsequence
        res = 1
        
        palindromes_list = list(palindromes.keys())
        for i in range(len(palindromes_list)):
            i1 = palindromes_list[i]
            s1 = palindromes[i1]
            for j in range(i+1, len(palindromes_list)):
                i2 = palindromes_list[j]
                s2 = palindromes[i2]
                if not (i1 & i2):
                    res = max(res, len(s1)*len(s2))
        
        return res