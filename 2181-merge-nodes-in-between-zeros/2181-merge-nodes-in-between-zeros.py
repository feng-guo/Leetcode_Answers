# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = head.next
        newList = head
        
        while True:
            if not current.next:
                newList.next = None
                return head
            if current.val == 0:
                newList = newList.next
                newList.val = 0
            newList.val += current.val
            current = current.next
        