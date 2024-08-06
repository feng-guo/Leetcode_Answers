from collections import Counter

class Solution:
    def minimumPushes(self, word: str) -> int:
        freq = Counter(word)
        count = 0
        for i, pair in enumerate(freq.most_common()):
            count += int(ceil((i+1)/8) * pair[1])
        
        return count
            
        