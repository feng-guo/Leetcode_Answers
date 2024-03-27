class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        n = len(matrix)
        m = len(matrix[0])
        self.prefix_matrix = [[0 for _ in range(m)] for _ in range(n)]
        for i in range(n):
            row_sum = 0
            for j in range(m):
                row_sum += matrix[i][j]
                up = 0
                if i > 0:
                    up = self.prefix_matrix[i-1][j]
                self.prefix_matrix[i][j] = up + row_sum
        

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        up = 0
        left = 0
        add_back = 0
        if row1 > 0:
            up = self.prefix_matrix[row1 - 1][col2]
        if col1 > 0:
            left = self.prefix_matrix[row2][col1-1]
        if col1 > 0 and row1 > 0:
            add_back = self.prefix_matrix[row1-1][col1-1]
        return self.prefix_matrix[row2][col2] - up - left + add_back
        


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)