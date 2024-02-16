class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        min_heap = []
        
        intervals.sort()
        print(intervals)
        sorted_queries = queries.copy()
        sorted_queries.sort()
        print(sorted_queries)
        ans = {}
        i = 0
        for query in sorted_queries:
            ##add all of the possible intervals to the heap
            while i < len(intervals) and intervals[i][0] <= query:
                heappush(min_heap, (intervals[i][1] - intervals[i][0] + 1, intervals[i][1]))
                i += 1
            
            ##get the best interval, remove them if it doesn't apply
            while len(min_heap) > 0 and min_heap[0][1] < query:
                heappop(min_heap)
            
            ##add the value to the map
            if len(min_heap) == 0:
                ans[query] = -1
            else:
                ans[query] = min_heap[0][0]
                
        
        res = []
        for query in queries:
            res.append(ans[query])
        
        return res