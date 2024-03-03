class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ""
        for i, c in enumerate(strs[0]):
            for string in strs:
                if i >= len(string) or string[i] != c:
                    return res
            res += c
        
        return res