from collections import defaultdict

class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        char_map = defaultdict(int)
        
        for word in words:
            for c in word:
                char_map[c] += 1
        
        for v in char_map.values():
            if v%len(words) != 0:
                return False
        
        return True