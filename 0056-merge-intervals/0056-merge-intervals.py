import heapq
class Solution:
    def negative(self, interval: List[int]) -> List[int]:
        return [-interval[0], -interval[1]]
    
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        pq: List[List[int]] = []
        res: List[List[int]] = []
        for interval in intervals:
            heapq.heappush(pq, interval)
        while len(pq) > 0:
            interval = heapq.heappop(pq)
            if len(res) == 0:
                heapq.heappush(res, self.negative(interval))
            else:
                prev = self.negative(heapq.heappop(res))
                if prev[0] <= interval[0] <= prev[1]:
                    heapq.heappush(res, self.negative([min(prev[0], interval[0]), max(prev[1], interval[1])]))
                else:
                    heapq.heappush(res, self.negative(prev))
                    heapq.heappush(res, self.negative(interval))
        actual: List[List[int]] = []
        for interval in res:
            actual.append(self.negative(interval))
        return actual
    