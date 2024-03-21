class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        letters_used = set()
        words_used = set()
        mapping = set()
        
        words = s.split()
        if len(words) != len(pattern):
            return False
        for i, c in enumerate(pattern):
            word = words[i]
            if (c, word) in mapping:
                continue
            if c not in letters_used and word not in words_used:
                letters_used.add(c)
                words_used.add(word)
                mapping.add((c, word))
            else:
                return False
        return True