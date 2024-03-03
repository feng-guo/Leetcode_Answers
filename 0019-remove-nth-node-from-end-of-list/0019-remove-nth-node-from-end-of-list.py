# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        
        
        c = head
        count = 0
        while c:
            count += 1
            c = c.next
        
        
        
        c = head
        remove = count - n
        
        if remove == 0:
            return c.next
        
        count = 0
        while True:
            if count == remove - 1:
                c.next = c.next.next
                return head
            c = c.next
            count += 1