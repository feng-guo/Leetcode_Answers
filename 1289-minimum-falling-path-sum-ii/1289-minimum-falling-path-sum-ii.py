class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        for i in range(1, len(grid)):
            for j in range(len(grid)):
                grid[i][j] += min(grid[i-1][:j] + grid[i-1][j+1:])
        
        return min(grid[-1])
        