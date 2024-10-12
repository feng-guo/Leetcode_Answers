class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        freeGroups = 0
        q = []
        heapq.heapify(q)
        
        intervals.sort()
        
        for interval in intervals:
            # take out all previous intervals off cooldown and add them to free group
            while len(q) > 0 and q[0] < interval[0]:
                heapq.heappop(q)
                freeGroups += 1
            # take a free group if available
            if freeGroups > 0:
                freeGroups -= 1
            # otherwise
            
            heapq.heappush(q, interval[1])
        
        return freeGroups + len(q)