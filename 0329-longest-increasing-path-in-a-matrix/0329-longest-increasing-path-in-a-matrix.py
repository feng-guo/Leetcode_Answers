class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        self.dp = [[-1 for y in range(len(matrix[0]))] for x in range(len(matrix))]
        dp = self.dp
        self.matrix = matrix
        
        longest = -math.inf
        
        for x in range(len(dp)):
            for y in range(len(dp[0])):
                cell = dp[x][y]
                if (cell == -1):
                    cell = self.find_longest(x, y)
                longest = max(longest, cell)
        
        return longest
    
    def find_longest(self, x, y) -> int:
        dp = self.dp
        m = self.matrix
        if (dp[x][y] != -1):
            return dp[x][y]
        
        up = 0
        down = 0
        left = 0
        right = 0
        if (x != 0 and m[x][y] < m[x-1][y]):
            left = self.find_longest(x-1, y)
        if (x != len(m)-1 and m[x][y] < m[x+1][y]):
            right = self.find_longest(x+1, y)
        if (y != 0 and m[x][y] < m[x][y-1]):
            up = self.find_longest(x, y-1)
        if (y != len(m[0])-1 and m[x][y] < m[x][y+1]):
            down = self.find_longest(x, y+1)
        dp[x][y] = 1 + max(up, down, left, right)
        return dp[x][y]