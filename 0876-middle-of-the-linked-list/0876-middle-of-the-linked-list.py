# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        c = head
        double = head
        while double.next:
            c = c.next
            double = double.next
            if not double.next:
                return c
            double = double.next
        return c
        