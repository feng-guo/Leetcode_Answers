# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        nodes = set()
        
        c = head
        while c:
            if c in nodes:
                return True
            nodes.add(c)
            c = c.next
        return False
            
        