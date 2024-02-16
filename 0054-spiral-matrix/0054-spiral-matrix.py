class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        left_bound = -1
        top_bound = -1
        right_bound = len(matrix[0])
        bottom_bound = len(matrix)
        
        size = right_bound * bottom_bound
        
        
        def dfs(x, y, directon):
            res.append(matrix[x][y])
            if len(res) == size:
                return
            
                
        x = y = 0
        d = "r"
        
        for i in range(size):
            res.append(matrix[x][y])
            if len(res) == size:
                return res
            if d == "r":
                if y + 1 == right_bound:
                    top_bound = x
                    x += 1
                    d = "d"
                else:
                    y += 1
            elif d == "l":
                if y - 1 == left_bound:
                    bottom_bound = x
                    x -= 1
                    d = "u"
                else:
                    y -= 1
            elif d == "d":
                if x + 1 == bottom_bound:
                    right_bound = y
                    y -= 1
                    d = "l"
                else:
                    x += 1
            elif d == "u":
                if x - 1 == top_bound:
                    left_bound = y
                    y += 1
                    d = "r"
                else:
                    x -= 1
            
        return res
        