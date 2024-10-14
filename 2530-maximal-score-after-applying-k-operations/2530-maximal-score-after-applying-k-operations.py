class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        res = 0
        q = [-num for num in nums]
        heapq.heapify(q)
        
        for i in range(k):
            popped = heapq.heappop(q)
            res -= popped
            heapq.heappush(q, -ceil(-popped/3))
        
        return res