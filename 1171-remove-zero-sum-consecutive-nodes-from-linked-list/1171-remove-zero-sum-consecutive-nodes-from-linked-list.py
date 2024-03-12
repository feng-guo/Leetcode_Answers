from collections import OrderedDict

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node_map = OrderedDict()
        count = 0
        current = head
        while current:
            count += current.val
            if count == 0:
                node_map = OrderedDict()      
            elif count not in node_map:
                node_map[count] = current
            else:
                next_node = current.next
                count_for_delete = count
                entry_to_delete = node_map[count].next
                while entry_to_delete != current:
                    count_for_delete += entry_to_delete.val
                    node_map.pop(count_for_delete)
                    entry_to_delete = entry_to_delete.next
                
                node_map[count].next = next_node
            current = current.next
        
        
        for node in node_map:
            return node_map[node]
        
        