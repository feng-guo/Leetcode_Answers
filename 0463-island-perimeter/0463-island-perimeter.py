class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        start_x = start_y = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    start_x, start_y = i, j
                    break
        
        visited = set()
        res = 0
        
        to_visit = [(start_x, start_y)]
        visited.add((start_x, start_y))
        
        while to_visit:
            x, y = to_visit.pop(0)
            if x != 0 and grid[x-1][y] == 1:
                if (x-1, y) not in visited:
                    visited.add((x-1, y))
                    to_visit.append((x-1, y))
            else:
                res += 1
            if x != len(grid) - 1 and grid[x+1][y] == 1:
                if (x+1, y) not in visited:
                    visited.add((x+1, y))
                    to_visit.append((x+1, y))
            else:
                res += 1
            if y != 0 and grid[x][y-1] == 1:
                if (x, y-1) not in visited:
                    visited.add((x, y-1))
                    to_visit.append((x, y-1))
            else:
                res += 1
            if y != len(grid[0]) - 1 and grid[x][y+1] == 1:
                if (x, y+1) not in visited:
                    visited.add((x, y+1))
                    to_visit.append((x, y+1))
            else:
                res += 1
        
        return res
            
        
        
        