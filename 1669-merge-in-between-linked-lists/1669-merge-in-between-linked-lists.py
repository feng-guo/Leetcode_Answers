# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        list2_last = list2
        while list2_last.next:
            list2_last = list2_last.next
        
        a_node = list1
        count = 0
        while count < a-1:
            a_node = a_node.next
            count += 1
        b_node = a_node
        while count <= b:
            b_node = b_node.next
            count += 1
        a_node.next = list2
        list2_last.next = b_node
        
        return list1
        
        