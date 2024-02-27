# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        
        def diameterAndMax(root):
            if not root:
                return -1, 0
            
            left, left_max = diameterAndMax(root.left)
            right, right_max = diameterAndMax(root.right)
            
            length = left + 1 + right + 1
            
            return max(left, right) + 1, max(left_max, right_max, length)
        
        return diameterAndMax(root)[1]
        