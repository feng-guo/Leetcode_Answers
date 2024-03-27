class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        for i, c in enumerate(haystack):
            if len(haystack) - i < len(needle):
                return -1
            if needle[0] == c:
                for j in range(len(needle)):
                    if needle[j] != haystack[i+j]:
                        break
                    elif j == len(needle) - 1:
                        return i
                
        
        
        return -1