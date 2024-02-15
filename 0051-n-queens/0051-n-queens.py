from collections import OrderedDict

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ##pop item (last = true)
        columns = OrderedDict()
        diagonal1 = set()
        diagonal2 = set()
        res = []
        
        def place(row_n):
            if row_n == n:
                ##It was successful and therefore we should add it
                soln = []
                for column in columns:
                    row_str = ""
                    for i in range(n):
                        if (i == column):
                            row_str += "Q"
                        else:
                            row_str += "."
                    soln.append(row_str)
                res.append(soln)
            for i in range(n):
                ##place it in the column
                if i not in columns:
                    columns[i] = row_n
                else:
                    continue
                
                ##place it in the pos diagonal
                pos = row_n - i
                
                if pos not in diagonal1:
                    diagonal1.add(pos)
                else:
                    columns.popitem(last=True)
                    continue
                
                ##place it in the neg diagonal
                neg = row_n + i
                if neg not in diagonal2:
                    diagonal2.add(neg)
                else:
                    columns.popitem(last=True)
                    diagonal1.remove(pos)
                    continue
                
                ##if successful then call the next row
                place(row_n+1)
                ##Remove it from the sets afterwards
                columns.popitem(last=True)
                diagonal1.remove(pos)
                diagonal2.remove(neg)
        
        place(0)
        return res
            