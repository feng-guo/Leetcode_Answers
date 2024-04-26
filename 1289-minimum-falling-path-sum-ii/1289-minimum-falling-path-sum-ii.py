class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        prev1 = (0, -1)
        prev2 = (0, -1)
        for i in range(0, len(grid)):
            min1 = None
            min2 = None
            for j in range(len(grid)):
                if j != prev1[1]:
                    grid[i][j] += prev1[0]
                else:
                    grid[i][j] += prev2[0]
                if not min1 or grid[i][j] <= min1[0]:
                    min2 = min1
                    min1 = (grid[i][j], j)
                elif not min2 or min1[0] < grid[i][j] < min2[0]:
                    min2 = (grid[i][j], j)
            prev1 = min1
            prev2 = min2
        
        return prev1[0]
        