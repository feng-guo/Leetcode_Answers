class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        num_negs = 0
        
        smallest = float('inf')
        
        total_sum = 0
        
        for i in range(len(matrix)):
            for j in range(len(matrix)):
                num = matrix[i][j]
                if num < 0:
                    num_negs += 1
                smallest = min(smallest, abs(num))
                total_sum += abs(num)
        
        if num_negs % 2 == 0 or smallest == 0:
            return total_sum
        else:
            return total_sum - 2*smallest