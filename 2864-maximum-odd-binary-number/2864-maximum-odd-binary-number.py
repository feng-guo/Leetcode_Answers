class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        count = 0
        for c in s:
            if c == "1":
                count += 1
        res = ""
        for i in range(count-1):
            res += "1"
        for i in range(len(s)-count):
            res += "0"
        res += "1"
        return res