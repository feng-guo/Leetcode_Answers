from collections import defaultdict

class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        to_place = []
        rows = defaultdict(set)
        columns = defaultdict(set)
        squares =  defaultdict(set)
        for i in range(len(board)):
            for j in range(len(board)):
                cell = board[i][j]
                if cell == ".":
                    to_place.append((i, j))
                else:
                    rows[i].add(int(cell))
                    columns[j].add(int(cell))
                    squares[(i//3)*3 + j//3].add(int(cell))
                    
                    
        def fillSudoku(index):
            if index == len(to_place):
                return True
            row, column = to_place[index]
            square = (row//3)*3 + column//3
            for i in range(1, 10):
                if i in rows[row] or i in columns[column] or i in squares[square]:
                    continue
                else:
                    rows[row].add(i)
                    columns[column].add(i) 
                    squares[square].add(i)
                    board[row][column] = str(i)
                    if fillSudoku(index + 1):
                        return True
                    else:
                        rows[row].remove(i)
                        columns[column].remove(i) 
                        squares[square].remove(i)
                        board[row][column] = "."
            return False
        
        fillSudoku(0)