class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        sorted_intervals = []
        for interval in intervals:
            sorted_intervals.append((interval[0], interval[1]))
        sorted_intervals.sort()
        
        covered = 0
        res = []
        for i, interval in enumerate(sorted_intervals):
            if res:
                prev = res[-1]
                if prev[0] <= interval[0] <= interval[1] <= prev[1]:
                    covered += 1
                elif interval[0] <= prev[0] <= prev[1] <= interval[1]:
                    res[-1] = interval
                    covered += 1
                else:
                    res.append(interval)
            else:
                res.append(interval)
        return len(intervals) - covered
                    