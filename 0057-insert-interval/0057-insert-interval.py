class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        place = False
        for interval in intervals:
            if interval[1] < newInterval[0]:
                res.append(interval)
            elif interval[0] <= newInterval[0] <= interval[1]:
                newInterval = [interval[0], max(interval[1], newInterval[1])]
            elif newInterval[0] <= interval[0] <= newInterval[1]:
                newInterval = [newInterval[0], max(interval[1], newInterval[1])]
            else:
                if not place:
                    res.append(newInterval)
                    place = True
                res.append(interval)
        if not place:
            res.append(newInterval)
        return res