class Solution:
    def minSwaps(self, s: str) -> int:
        extra_close = 0
        max_close = 0
        for c in s:
            if c == "]":
                extra_close += 1
                max_close = max(max_close, extra_close)
            else:
                extra_close -= 1
        return (max_close + 1)//2
        