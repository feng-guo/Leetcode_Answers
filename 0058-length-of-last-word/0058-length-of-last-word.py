class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        words = s.split()
        for i in range(len(words)):
            word = words[-1-i]
            if word:
                return len(word)
        