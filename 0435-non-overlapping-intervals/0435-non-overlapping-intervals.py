import math

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        end = -math.inf
        count = 0
        for interval in intervals:
            x, y = interval
            if x < end:
                count += 1
                if y < end:
                    end = y
            else:
                end = y
        return count
        