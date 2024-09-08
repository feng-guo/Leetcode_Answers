# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        count = 0
        current = head
        while current != None:
            count += 1
            current = current.next
        
        parts = count // k
        extra = count % k
        # extra number of k-splits will have 1 more than parts
        
        res = [None] * k
        
        current = head
        prev = None
        for i in range(k):
            for j in range(parts):
                if current == None:
                    break
                # add current as list head if necessary
                if j == 0:
                    res[i] = current
                prev = current
                current = current.next
            if extra:
                extra -= 1
                if res[i] == None:
                    res[i] = current
                prev = current
                current = current.next
            if prev != None:
                prev.next = None
            
        return res
                
                
        