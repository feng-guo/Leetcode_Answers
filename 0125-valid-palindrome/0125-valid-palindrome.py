class Solution:
    def isPalindrome(self, s: str) -> bool:
        removed = ""
        s = s.lower()
        for c in s:
            if "a" <= c <= "z" or "0" <= c <= "9":
                removed += c
        s = removed
        return s == s[::-1]
        