# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        arr = []
        
        while head:
            arr.append(head.val)
            head = head.next
        
        def createTree(nodes):
            if not nodes:
                return None
            mid = len(nodes) // 2
            return TreeNode(nodes[mid], createTree(nodes[:mid]), createTree(nodes[mid+1:]))
        
        return createTree(arr)