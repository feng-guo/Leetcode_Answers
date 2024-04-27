from collections import defaultdict

class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        letter_map = defaultdict(set)
        for i, c in enumerate(ring):
            letter_map[c].add(i)
        prev_map = defaultdict(set)
        prev_map[-1].add((0, 0))
        for i, c in enumerate(key):
            for pos in letter_map[c]:
                prev_map[i].add((pos, min([min(abs(c[0]-pos), len(ring)-abs(c[0]-pos)) + c[1] for c in prev_map[i-1]]) + 1))
        return min([c[1] for c in prev_map[len(key)-1]])
    
    
    