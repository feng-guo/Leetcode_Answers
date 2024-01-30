import heapq

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        cost = 0
        visited = set()
        best_cost_map = {}
        queue = [(0, 0)]
        while len(queue) > 0:
            edge_cost, x = heapq.heappop(queue)
            if x in visited:
                continue
            cost += edge_cost
            visited.add(x)
            for y in range(len(points)):
                if x == y or y in visited:
                    continue
                distance = abs(points[x][0] - points[y][0]) + abs(points[x][1] - points[y][1])
                if y not in best_cost_map or distance < best_cost_map[y]:
                    best_cost_map[y] = distance
                    heapq.heappush(queue, (distance, y))
        
        return cost
                    
                
        