class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        for i in range(0, len(matrix), 2):
            start = 0 + i//2
            end = len(matrix) - 1 - i//2
            for j in range(0, len(matrix)-i-1):
                matrix[start][start+j], matrix[start+j][end], matrix[end][end-j], matrix[end-j][start] = matrix[end-j][start], matrix[start][start+j], matrix[start+j][end], matrix[end][end-j]
        