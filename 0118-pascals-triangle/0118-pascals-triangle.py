class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        p_triangle = []
        
        for i in range(numRows):
            row = []
            for j in range(i+1):
                if j == 0:
                    row.append(1)
                elif j == i:
                    row.append(1)
                else:
                    row.append(p_triangle[i-1][j-1] + p_triangle[i-1][j])
            p_triangle.append(row)
        
        return p_triangle