# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        if depth == 1:
            root = TreeNode(val, root, None)
        else:
            current = 1
            q = [root]
            while current < depth:
                new_q = []
                for node in q:
                    if current + 1 == depth:
                        ##need to set
                        node.left = TreeNode(val, node.left, None)
                        node.right = TreeNode(val, None, node.right)
                    else:
                        if node.left:
                            new_q.append(node.left)
                        if node.right:
                            new_q.append(node.right)
                current += 1
                q = new_q
        
        return root
        