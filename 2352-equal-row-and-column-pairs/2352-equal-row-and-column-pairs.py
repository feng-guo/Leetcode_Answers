from collections import defaultdict

class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        rows = defaultdict(int)
        for i, row in enumerate(grid):
            rows[tuple(row)] += 1
        count = 0
        for y in range(len(grid[0])):
            col = []
            for x in range(len(grid)):
                col.append(grid[x][y])
            count += rows[tuple(col)]
        return count