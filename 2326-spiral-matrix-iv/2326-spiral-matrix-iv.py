# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def spiralMatrix(self, m: int, n: int, head: Optional[ListNode]) -> List[List[int]]:
        count = m * n
        res = [[float('inf') for _ in range(n)] for _ in range(m)]
        
        current = head
        x, y = 0, 0
        d = 'r'
        
        for i in range(count):
            num = -1
            if current != None:
                num = current.val
                current = current.next
            res[x][y] = num
            
            if d == 'r':
                y += 1
                if y == n or res[x][y] != float('inf'):
                    y -= 1
                    x += 1
                    d = 'd'
            elif d == 'd':
                x += 1
                if x == m or res[x][y] != float('inf'):
                    x -= 1
                    y -= 1
                    d = 'l'
            elif d == 'l':
                y -= 1
                if y == -1 or res[x][y] != float('inf'):
                    y += 1
                    x -= 1
                    d = 'u'
            elif d == 'u':
                x -= 1
                if x == -1 or res[x][y] != float('inf'):
                    x += 1
                    y += 1
                    d = 'r'
        return res