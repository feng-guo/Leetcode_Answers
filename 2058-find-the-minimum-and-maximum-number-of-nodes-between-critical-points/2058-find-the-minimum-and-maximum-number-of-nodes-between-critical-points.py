# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        res = [float('inf'), -1]
        first_crit = -1
        last_crit = -1
        prev_val = -1
        
        current = head
        i = 0
        
        while current:
            if not current.next:
                break
            if prev_val != -1:
                is_crit = False
                if (current.val > prev_val and current.val > current.next.val) or (current.val < prev_val and current.val < current.next.val):
                    if first_crit == -1:
                        first_crit = i
                        last_crit = i
                    else:
                        res = [min(res[0], i - last_crit), i - first_crit]
                        last_crit = i
                    
            i += 1
            prev_val = current.val
            current = current.next
        
        if res[1] == -1:
            return [-1, -1]
        
        return res
        