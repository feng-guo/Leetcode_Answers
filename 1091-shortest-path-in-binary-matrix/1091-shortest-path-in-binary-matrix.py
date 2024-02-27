class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1:
            return -1
        if grid[len(grid)-1][len(grid[0])-1] == 1:
            return -1
        
        distance = {}
        
        queue = []
        queue.append((0, 0))
        distance[(0, 0)] = 1
        while queue:
            x, y = queue.pop(0)
            d = distance[(x, y)]
            if x < 0 or x > len(grid)-1 or y < 0 or y > len(grid[0])-1:
                distance[(x, y)] = -1
                continue
            if grid[x][y] == 1:
                distance[(x, y)] = -1
                continue
            if (x-1, y) not in distance:
                queue.append((x-1, y))
                distance[(x-1, y)] = d+1
            if (x+1, y) not in distance:
                queue.append((x+1, y))
                distance[(x+1, y)] = d+1
            if (x-1, y-1) not in distance:
                queue.append((x-1, y-1))
                distance[(x-1, y-1)] = d+1
            if (x-1, y+1) not in distance:
                queue.append((x-1, y+1))
                distance[(x-1, y+1)] = d+1
            if (x+1, y-1) not in distance:
                queue.append((x+1, y-1))
                distance[(x+1, y-1)] = d+1
            if (x+1, y+1) not in distance:
                queue.append((x+1, y+1))
                distance[(x+1, y+1)] = d+1
            if (x, y-1) not in distance:
                queue.append((x, y-1))
                distance[(x, y-1)] = d+1
            if (x, y+1) not in distance:
                queue.append((x, y+1))
                distance[(x, y+1)] = d+1
        
        
        if (len(grid)-1, len(grid[0])-1) in distance:
            return distance[(len(grid)-1, len(grid[0])-1)]
        return -1