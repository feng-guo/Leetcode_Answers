class SummaryRanges:

    def __init__(self):
        self.intervals = []
        self.sorted = True

    def addNum(self, value: int) -> None:
        self.intervals.append([value, value])
        self.sorted = False
        

    def getIntervals(self) -> List[List[int]]:
        if not self.sorted:
            self.intervals.sort()
        new_intervals = []
        for interval in self.intervals:
            if not new_intervals :
                new_intervals.append(interval)
            elif new_intervals[-1][0] <= interval[0] <= new_intervals[-1][1] + 1:
                new_intervals[-1][1] = max(new_intervals[-1][1], interval[1])
            else:
                new_intervals.append(interval)
        
        self.intervals = new_intervals
        self.sorted = True
        return self.intervals
        


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()