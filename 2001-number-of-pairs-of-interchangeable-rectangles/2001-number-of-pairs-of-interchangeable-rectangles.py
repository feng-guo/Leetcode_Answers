from collections import defaultdict

class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        ratio_map = defaultdict(int)
        res = 0
        for rectangle in rectangles:
            ratio = rectangle[0] / rectangle[1]
            res += ratio_map[ratio]
            ratio_map[ratio] += 1
            
        return res