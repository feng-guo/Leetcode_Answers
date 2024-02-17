import math

class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        
        heap = []
        prev = math.inf
        for i in range(len(heights)):
            next_building = heights[i]
            diff = next_building - prev
            if (diff > 0 and diff <= bricks):
                heappush(heap, diff*-1)
                bricks -= diff
            elif (diff > 0):
                if (ladders == 0):
                    return i-1
                ladders -= 1
                if (len(heap) > 0 and heap[0]*-1 > diff):
                    refund = heappop(heap) * -1
                    heappush(heap, diff*-1)
                    bricks += refund
                    bricks -= diff
            prev = next_building
        return len(heights) -  1
            
        