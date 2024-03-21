from collections import defaultdict

class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        max_edges = 0
        edge_map = defaultdict(int)
        
        for row in wall:
            count = 0
            for i in range(len(row)-1):
                brick = row[i]
                count += brick
                edge_map[count] += 1
                max_edges = max(max_edges, edge_map[count])
            
        return len(wall) - max_edges
                    