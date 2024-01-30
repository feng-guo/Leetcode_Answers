from collections import defaultdict
import heapq

class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        edge_map = defaultdict(list)
        best_cost_map = {}
        visited = set()
        edges_unused = set()
        
        for x in range(len(edges)):
            edge = edges[x]
            edge_map[edge[0]].append([edge[1], x])
            edge_map[edge[1]].append([edge[0], x])
            edges_unused.add(x)
            
        
        queue = [(0, edges[0][0])]
        best_cost_map[edges[0][0]] = 0
        while len(queue) > 0:
            cost, current = heapq.heappop(queue)
            if (cost > best_cost_map[current]):
                continue
            if not (current == edges[0][0]):
                edges_unused.remove(cost)
            visited.add(current)
            for edge in edge_map[current]:
                next_node, cost = edge
                if next_node in visited:
                    continue
                if next_node not in best_cost_map or cost < best_cost_map[next_node]:
                    best_cost_map[next_node] = cost
                    heapq.heappush(queue, (cost, next_node))
        
        y = 0
        for unused in edges_unused:
            y = unused
        
        return edges.pop(y)
        