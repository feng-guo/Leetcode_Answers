class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        row_0 = 1
        for x, row in enumerate(matrix):
            for y, cell in enumerate(row):
                if cell == 0:
                    if x == 0:
                        row_0 = 0
                    else:
                        matrix[x][0] = 0
                    matrix[0][y] = 0
        
        for y in range(1, len(matrix[0])):
            if matrix[0][y] == 0:
                for x in range(1, len(matrix)):
                    matrix[x][y] = 0
        for x in range(1, len(matrix)):
            if matrix[x][0] == 0:
                for y in range(1, len(matrix[0])):
                    matrix[x][y] = 0
        if matrix[0][0] == 0:
            for x in range(0, len(matrix)):
                matrix[x][0] = 0
        if row_0 == 0:
            for y in range(0, len(matrix[0])):
                matrix[0][y] = 0
                
                