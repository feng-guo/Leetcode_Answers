import math

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        best_time = [[math.inf for j in range(len(grid[0]))] for i in range(len(grid))]
        best_time[0][0] = grid[0][0]
        
        queue = []
        queue.append((0, 0, best_time[0][0]))
        
        while len(queue) > 0:
            x, y, time = queue.pop(0)
            
            if x > 0:
                #left
                x2 = x-1
                y2 = y
                cost = grid[x2][y2]
                best = best_time[x2][y2]
                new_best = max(time, cost)
                if (new_best < best):
                    best_time[x2][y2] = new_best
                    queue.append((x2, y2, new_best))
            if x < len(grid) - 1:
                #right
                x2 = x+1
                y2 = y
                cost = grid[x2][y2]
                best = best_time[x2][y2]
                new_best = max(time, cost)
                if (new_best < best):
                    best_time[x2][y2] = new_best
                    queue.append((x2, y2, new_best))
            if y > 0:
                #up
                x2 = x
                y2 = y-1
                cost = grid[x2][y2]
                best = best_time[x2][y2]
                new_best = max(time, cost)
                if (new_best < best):
                    best_time[x2][y2] = new_best
                    queue.append((x2, y2, new_best))
            if y < len(grid[0]) - 1:
                #down
                x2 = x
                y2 = y+1
                cost = grid[x2][y2]
                best = best_time[x2][y2]
                new_best = max(time, cost)
                if (new_best < best):
                    best_time[x2][y2] = new_best
                    queue.append((x2, y2, new_best))

        
        
        return best_time[len(grid)-1][len(grid[0])-1]